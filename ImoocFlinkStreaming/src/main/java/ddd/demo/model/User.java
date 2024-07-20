package ddd.demo.model;

/**
 * author: Imooc
 * description: ddd 领域模型
 * date: 2023
 */
/* **********************
 *
 * 知识点：
 *
 * 一。
 *
 * 传统的POJO 对象 （数据传输的载体）：
 * 1. POJO 对象的属性
 * 2. 属性的 GET/SET 的方法。
 *
 * ddd 领域驱动设计的模型 (Model):
 * 1. POJO 对象的属性
 * 2. 属性的 GET/SET 的方法。
 * 3. POJO 对象具体的业务动作
 *
 * ddd 领域驱动设计的模型(Model) 既是数据传输的载体，也是处理具体的业务逻辑
 *
 * 二。
 *
 * POJO 对象:
 * 1. VO 视图数据对象
 * 2. DTO 数据传输对象
 * 3. PO 数据持久化对象
 *
 * 三。
 *
 * 传统多个服务共用一个数据库
 * 微服务是每个服务有自己的数据库
 * 微服务之间是通过暴露Api(RPC)进行数据交换
 *
 * 事件驱动架构（使用事件实现跨多个服务的业务逻辑）
 * 某个服务会发布事件，其他服务会订阅这个事件，
 * 当某一微服务接收到事件就可以更新自己的业务数据，同时发布新的事件触发下一步更新
 *
 * 四。
 *
 * ddd 领域驱动设计的模型 (Model) 的种类：
 * 1. Entity （实体）：内部值是变化的，且具有状态对象 （如：订单对象）
 * 2. Value Project（值对象）：内部值是不变的，没有状态对象
 * 3. Service 对象：Entity 和 Value 对象都模棱两可，就可以放在Service 对象
 *
 *
 *
 * *********************/
public class User {

    //用户登录的业务逻辑
    private LoginAction loginAction;
    //用户购买的业务逻辑
    private SaleAction saleAction;
    private String Name;
    private Integer age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
