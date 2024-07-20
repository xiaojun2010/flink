package groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.codehaus.groovy.control.CompilerConfiguration;

/**
 * author: Imooc
 * description: Java通过类加载器调用 Groove 自定义类 (字符串形式)
 * date: 2024
 */

public class GroovyClassLoaderParseClassWithString {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        // 这个GroovyClassLoader的父加载器是当前线程的类加载器
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(
                //当前线程的类加载器
                Thread.currentThread().getContextClassLoader(),
                new CompilerConfiguration()
        );

        // groovy 脚本内容
        String groovy_script_string = "class ScriptEngine {void print() {println('this is Groovy Class By GroovyClassLoader With String');}}";

        //通过GroovyClassLoader加载类
        Class<?> groovyClass = groovyClassLoader.parseClass(groovy_script_string);

        //获取ScriptEngine对象实例
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();

        //通过invoke调用实例方法
        groovyObject.invokeMethod("print",null);
    }
}
