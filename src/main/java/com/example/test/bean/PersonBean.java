package com.example.test.bean;

public class PersonBean {
    private String sfz;
    private String name;
    private String sex;
    private int age;
    private int hjid;

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "sfz='" + sfz + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", hjid=" + hjid +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHjid() {
        return hjid;
    }

    public void setHjid(int hjid) {
        this.hjid = hjid;
    }
}
