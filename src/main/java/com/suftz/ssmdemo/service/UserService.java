package com.suftz.ssmdemo.service;

import com.suftz.ssmdemo.bean.User;
import com.suftz.ssmdemo.dao.DepartmentDao;
import com.suftz.ssmdemo.dao.UserDao;
import com.suftz.ssmdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author zhangchengy
 * @version 1.0
 * @date 2021/1/29 17:27
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean add(User user){
        return userMapper.addUser(user);
    }

    public boolean update(User user){
        return userMapper.updateUser(user);
    }

    public List<User> getUsers(){
        return userMapper.getAllUser();
    }

    public User get(Integer uid){
        return userMapper.getUserAndDept(uid);
    }

    public boolean delete(Integer uid){
        return userMapper.deleteUserByUid(uid);
    };
}
