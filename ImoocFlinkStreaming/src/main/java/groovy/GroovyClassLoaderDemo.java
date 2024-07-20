package groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * author: Imooc
 * description: Java通过类加载器调用 Groove 自定义类 (脚本文件形式)
 * date: 2023
 */


public class GroovyClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        /* **********************
         *
         * 知识点：
         *
         * 1.
         * 通过类加载器调用Groovy自定义类步骤
         *
         * a.实例化一个GroovyClassLoader的对象
         * b.GroovyClassLoader 解析groovy脚本并生成一个Class对象
         * c.实例化一个GroovyObject
         * d.通过GroovyObject执行自定义类中的方法
         *
         *
         */

        // 这个GroovyClassLoader的父加载器是当前线程的类加载器
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(
                //当前线程的类加载器
                Thread.currentThread().getContextClassLoader(),
                new CompilerConfiguration()
        );

        //groovy脚本路径
        File script = new File("src/main/groovy/scripts/ScriptEngine.groovy");

        //通过GroovyClassLoader加载类
        Class<?> groovyClass = groovyClassLoader.parseClass(script);

        //获取ScriptEngine对象实例
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();

        //通过invoke调用实例方法
        groovyObject.invokeMethod("print",null);

    }
}
