package groovy;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;

/**
 * author: Imooc
 * description: GroovyScriptEngine从指定的位置加载Groovy脚本
 * date: 2023
 */

public class GroovyScriptEngineDemo {
    public static void main(String[] args) throws IOException, ScriptException, ResourceException {

        //初始化 GroovyScriptEngine
        GroovyScriptEngine engine = new GroovyScriptEngine("src/main/groovy/scripts");
        //初始化 Binding
        Binding binding = new Binding();

        //执行脚本
        engine.run("engine.groovy",binding);


    }
}
