package groovy;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;

/**
 * zxj
 * description: GroovyScriptEngine从指定的位置加载Groovy脚本,脚本改动可重新加载
 * date: 2023
 */

public class GroovyScriptEngineDemo {
    public static void main(String[] args) throws IOException, ScriptException, ResourceException {

        // GroovyScriptEngine 根路径
        GroovyScriptEngine engine = new GroovyScriptEngine("src/main/groovy/scripts");
        Binding binding = new Binding();
        binding.setVariable("name", "imooc-GroovyScriptEngine");
        Object result1 = engine.run("ScriptEngine_1.groovy", binding);
        Object result2 = engine.run("ScriptEngine_2.groovy", binding);

    }
}
