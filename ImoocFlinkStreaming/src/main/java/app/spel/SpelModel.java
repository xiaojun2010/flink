package app.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * author: Imooc
 * description: SpEL demo
 * date: 2023
 */

/* **********************
 *
 * 知识点：
 *
 * 1.
 * el: expression language 表达式语言
 * spEL: spring expression language Spring表达式语言
 *
 * 2.
 * spEL 执行的方式：
 * a. @Value
 * b. 在代码里使用ExpressionParser
 * c. xml的配置文件
 *
 *
 * *********************/
@Component
public class SpelModel {

    @Value("${cn.imooc.el.name}")
    private String el_1;

    @Value("#{${cn.imooc.spel.name}}")
    private Map<String,String> el_2;

    @Value("#{'${cn.imooc.spel.name2}'.split('#')}")
    private List<String> el_3;

    public String getEl_1() {
        return el_1;
    }

    public Map<String, String> getEl_2() {
        return el_2;
    }

    public List<String> getEl_3() {
        return el_3;
    }
}
