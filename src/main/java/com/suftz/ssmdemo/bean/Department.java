package com.suftz.ssmdemo.bean;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @author zhangchengy
 * @version 1.0
 * @date 2021/1/28 21:38
 */
public class Department implements Serializable {

    @NotNull
    private Integer id;
    private String name;

    private static final long serialVersionUID=1L;

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
