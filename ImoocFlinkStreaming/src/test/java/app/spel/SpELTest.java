package app.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * zxj
 * description: SpEL 单元测试
 * date: 2023
 */

@SpringBootTest
public class SpELTest {

    @Autowired
    SpelModel spelModel;

    /**
     * zxj
     * description: 测试 @value 执行的spel
     * @param :
     * @return void
     */
    @Test
    public void testSpELByValue() {
        System.out.println(spelModel.getEl_2());
        System.out.println(spelModel.getEl_3());
    }

    /**
     * zxj
     * description: 测试 ExpressionParser 执行的 spel
     * @param :
     * @return void
     */
    @Test
    public void testSpELByExpParser() {

        ExpressionParser expressionParser = new SpelExpressionParser();
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.setVariable("name","imooc");

        System.out.println(expressionParser.parseExpression("1>2").getValue(Boolean.class));
        System.out.println(expressionParser.parseExpression("2^3").getValue(Integer.class));
        System.out.println(expressionParser.parseExpression("(3<2||2==2)&&(4==5)").getValue(Boolean.class));
        System.out.println(expressionParser.parseExpression("#name").getValue(standardEvaluationContext,String.class));

    }
}
