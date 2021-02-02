package com.suftz.ssmdemo.dao;

import com.suftz.ssmdemo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author zhangchengy
 * @version 1.0
 * @date 2021/1/26 10:54
 */
@Repository(value = "userDao")
public class UserDao {

    @Autowired
    private  DepartmentDao departmentDao;


    public boolean save(User user){
        return false;
    }

    public List<User> getUsers(){
        return null;
    }

    public User get(Integer uid){
        return null;
    }

    public boolean delete(Integer uid){
        return false;
    };


}
