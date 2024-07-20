package pojo;

import org.apache.flink.api.java.typeutils.TypeExtractor;

/**
 * author: Imooc
 * description: 判断是否为Flink认可的POJO对象
 * date: 2023
 */

public class PojoTypeCheck {

    public static void main(String[] args) {

        /* **********************
         *
         * 知识点：
         *
         * 1.
         * 如果返回的是PojoType,
         * 则对象会被Flink视为POJO对象,
         * 序列化使用的是 PojoSerializer
         * 并且序列化的时候, 就只会序列化字段, 方法不会被序列化
         * 反序列化的时候, 会根据公有的无参构造方法, 去构造对象
         *
         * 2.
         * 如果返回的是GenericType，
         * 则对象不会被Flink视为POJO对象,
         * 序列化使用的就是 kryo
         *
         *
         *
         * *********************/


        System.out.println("具有私有成员变量的POJO对象: "+TypeExtractor.createTypeInfo(UserPoPrivateField.class));
        System.out.println("具有公有成员变量的POJO对象: "+TypeExtractor.createTypeInfo(UserPoPublicField.class));
        System.out.println("实现了接口的POJO对象: "+TypeExtractor.createTypeInfo(UserPoImplement.class));
        System.out.println("具有私有成员变量但没有Getter和Setter的POJO对象: "+TypeExtractor.createTypeInfo(UserPoPrivateFieldWithoutGetSet.class));
    }
}
