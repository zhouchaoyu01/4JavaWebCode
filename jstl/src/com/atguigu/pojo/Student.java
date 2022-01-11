package com.atguigu.pojo;

/**
 * @author ChanceZhou
 * @create 2021-11-13-10:57
 */
public class Student {
    private String id;
    private String username;
    private String password;
    private String phone;
    private int age;

    public Student() {

    }

    public Student(String id, String username, String password, String phone, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
