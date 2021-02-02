package com.suftz.ssmdemo.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

/**
 * Description:
 *
 * @author zhangchengy
 * @version 1.0
 * @date 2021/1/27 22:21
 */
//@Alias(value = "user")
public class User {
    private Integer uid;
    @NotEmpty
    private String name;
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @DecimalMax("150")
    private Integer age;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Length(max = 30)
    private String address;

    @NotNull
    @Valid
    private Department dept;
    public User() {
    }

    public User(String name,Integer age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public User(Integer uid, String name, Integer age, String email, String address) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public User(Integer uid, String name, Integer age, String email, String address, Department dept) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.dept = dept;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                //", dpt=" + dept +
                '}';
    }
}
