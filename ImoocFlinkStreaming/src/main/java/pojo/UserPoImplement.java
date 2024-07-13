package pojo;

/**
 * zxj
 * description: 实现了接口的POJO对象
 * date: 2023
 */

public class UserPoImplement implements Person {

    private String name;

    public UserPoImplement() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void write() {

    }
}
