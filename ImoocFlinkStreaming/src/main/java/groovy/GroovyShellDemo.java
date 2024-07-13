package groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * zxj
 * description: GroovyShell 运行 Groovy脚本
 * date: 2023
 */

/* **********************
 *
 * 知识点：
 *
 * 1.
 * Groovy 是动态的，运行在JVM的脚本语言
 * Scala 运行在JVM的函数式语言
 *
 * 所有.groovy文件会经过 groovyc 编译成class文件,
 * 对于JVM来说与Java编译后没有区别.
 *
 * 2.
 *
 * 编写 Groovy 代码的两种风格：
 * a. 脚本 (不定义和 .groovy 同名的 class )
 * b. 类 (定义 class, 所有代码在 class)
 *
 * 如果 .groovy 文件内部出现了和文件同名的类,
 * 则这个 .groovy 文件会被视作是"用 Groovy 方言编写的 Java 代码",
 * 不能用作脚本使用, 只能看作普通的类
 *
 * 在 .groovy 文件, 可以不声明任何类
 *
 * 3.
 * idea 要选择 Groovy Class
 * idea 要设置 Groovy目录为源码目录, 否则会找不到 Groovy类
 *
 * 4.
 * Java应用在运行时集成Groovy的三种方式
 * a. GroovyShell: 在Java类中,使用Binding对象输入参数给表达式
 * b. GroovyClassLoader : 是一个定制的类装载器, 负责解释加载Java类中用到的Groovy类
 * c. GroovyScriptEngine: 指定位置加载Groovy脚本，并且随着脚本变化而重新加载它们
 *
 * 5.
 * Groovy 的 property 和 field:
 * property: 对象的属性 如 A.name, 其实调用 A.getName() , 用于类的外部
 * field: 类的成员变量, 用于类的内部, 使用 this 访问
 *
 * Groovy 默认在类的外部, 以property的形式访问对象属性: A.name
 *
 * Groovy 定义property的条件是 类型+名字, 没有访问修饰符(public,private)
 *
 *
 * 6.
 * groovy property 可以在构造方法里初始化
 *
 * 7.
 * groovy property 使用 final 修饰就不会生成 setter 方法,
 * 即 property 只读, 即使在类的内部, 也是只读
 *
 * 8. Groovy 变量作用域：
 * a. 本地作用域
 * b. 绑定作用域
 *
 * 9. Groovy 变量定义 2 种方式：
 * a. 直接声明：相当于 public 共有变量, 即绑定作用域
 * b. 使用 def 声明：相当于 private 私有变量, 即本地作用域
 *
 *
 *
 * *********************/

public class GroovyShellDemo {
    public static void main(String[] args) {



        // groovy 脚本内容
        String groovy_script = "println 'groovy '; 'name = ' + name;";
        Integer imoocNum = 1;
        //初始化 Binding
        Binding binding = new Binding();


        /* ***********
         *
         * GroovyShell 传参
         *
         * ************/

        //使用setProperty
        binding.setProperty("imoocNum", imoocNum);
        //使用setVariable
        binding.setVariable("name", "imooc");

        //创建脚本对象
        GroovyShell shell = new GroovyShell(binding);

        /* **********************
         *
         * 注意：
         * groovyShell.evaluate()方法中会先parse脚本为Script对象。parse相对耗
         *
         * *********************/
        //执行脚本方案1, 得到返回值
        shell.evaluate("imoocNum++;");
        Object variableRes = shell.evaluate(groovy_script);
        System.out.println(variableRes);
        System.out.println(String.format("Property = %s", binding.getProperty("imoocNum")));

        //执行脚本方案2
        Script script = shell.parse(groovy_script);
        System.out.println(script.run());


    }
}
