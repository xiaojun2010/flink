package groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * author: Imooc
 * description: GroovyShell 运行 Groovy脚本
 * date: 2023
 */

/* **********************
 *
 * 知识点：
 *
 * 1.
 * Groovy 运行在JVM的脚本语言
 *
 * Groovy和Java是无缝连接
 * Java应用在运行时动态的集成Groovy脚本
 *
 *
 * 2.
 * Java应用在运行时集成Groovy的3种方式
 * a. GroovyShell:
 *    GroovyShell每一次执行时代码时会动态将代码编译成Java Class
 *    在Java类中,使用Binding对象输入参数给表达式
 *    缺点：性能较差
 * b. GroovyScriptEngine:
 *    优点：指定位置加载Groovy脚本，并且随着脚本变化而重新加载它们
 * c. GroovyClassLoader:
 *    是一个定制的类装载器, 负责解释加载Java类中用到的Groovy类
 *
 * 3.
 * 编写 Groovy 代码的两种风格：
 * a. 脚本 (不定义和 .groovy 同名的 class )
 * b. 类 (定义 class, 所有代码在 class)
 *
 * 4.
 * Groovy 编译器会将脚本编译为类
 * 如果Groovy脚本文件里只有执行代码，没有定义任何类
 * 编译器会生成一个Script的子类,
 * 类名和脚本文件的文件名一样,
 * 脚本的代码会被包含在一个名为run的方法中
 *
 * 5.
 * 如果Groovy脚本文件有执行代码, 并且有定义类
 * 生成对应的class文件,
 * 脚本本身也会被编译成一个Script的子类
 *
 *
 * 6.
 * 如果 .groovy 文件内部出现了和文件同名的类,
 * 则这个 .groovy 文件会被视作是"用 Groovy 语言编写的 Java 代码",
 * 不能用作脚本使用, 只能看作普通的类
 *
 * 7。
 * JVM实现类的动态加载的底层逻辑
 * 一个类被首次加载后，会长期留驻JVM，直到JVM退出，这个说法是正确的吗？
 * 答案, 是正确的。但是有一个前提，这个类的加载是符合双亲委派模型
 * 双亲委派模型：所有的类都尽可能由顶层的类加载器加载，保证了加载的类的唯一性
 * 由JVM自带的类加载器所加载的类，在JVM的生命周期中，始终不会被卸载
 *
 * 自定义类加载器,所加载的类, 打破双亲委派模型,不要委托给父类加载器， 就能够实现类的动态加载
 *
 *
 * 8.
 * Groovy的动态加载脚本的底层逻辑
 * 原因：打破双亲委派模型
 * 底层逻辑： GroovyClassLoader打破双亲委派模型, 从而实现了Groovy能够动态加载Class的功能
 *
 * 9.
 * GroovyShell的evaluate(),调用GroovyClassLoader中的parseClass(),
 * GroovyScriptEngine的run(),调用GroovyClassLoader中的parseClass(),
 *
 */

public class GroovyShellDemo {
    public static void main(String[] args) {


        // groovy 脚本内容
        String groovy_script = "println 'groovy ';println 'name = ' + name;";
        //初始化 Binding
        Binding binding = new Binding();

        /* ***********
         *
         * GroovyShell 传参
         *
         * ************/

        //使用setVariable
        binding.setVariable("name", "imooc");

        //创建脚本对象
        GroovyShell shell = new GroovyShell(binding);

        //执行脚本
        Object variableRes = shell.evaluate(groovy_script);


    }
}
