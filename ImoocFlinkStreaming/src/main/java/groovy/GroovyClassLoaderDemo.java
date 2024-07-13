package groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

/**
 * zxj
 * description: Java动态执行 Groove 代码
 * date: 2023
 */

/* **********************
 *
 *
 * 知识点：
 *
 * 1.
 * invokeMethod()
 * 第1个参数是脚本中的函数名称，
 * 第2个参数是为绑定的参数
 *
 * *********************/

public class GroovyClassLoaderDemo {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        loadByFile();
        loadByClass();
    }

    /**
     * zxj
     * description: 通过类加载执行 Groovy代码
     * @param :
     * @return void
     */
    private static void loadByClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        GroovyObject groovyObject =
                (GroovyObject) GroovyClassLoaderDemo.class
                        .getClassLoader()
                        .loadClass("ImoocClassGroovy")
                        .newInstance();
        groovyObject.invokeMethod("print",null);

    }

    /**
     * zxj
     * description: 通过文件路径执行 Groovy代码
     * @param :
     * @return void
     */
    private static void loadByFile() throws IOException, InstantiationException, IllegalAccessException {
        File groovyFile = new File("src/main/groovy/Imooc.groovy");
        GroovyClassLoader loader =  new GroovyClassLoader();
        // 获得ImoocGroovy加载后的class
        Class<?> groovyClass = loader.parseClass(groovyFile);
        // 获得ImoocGroovy的实例
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
        // 反射调用printHello方法得到返回值
        groovyObject.invokeMethod("printHello", null);
    }
}
