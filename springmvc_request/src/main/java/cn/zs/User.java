package cn.zs;

import java.util.Arrays;

public class User {
    private String name;
    private Integer age;
    private Boolean isMarry;
    private Float income;
    private String [] interests;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMarry=" + isMarry +
                ", income=" + income +
                ", interests=" + Arrays.toString(interests) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(Boolean marry) {
        isMarry = marry;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }
}
