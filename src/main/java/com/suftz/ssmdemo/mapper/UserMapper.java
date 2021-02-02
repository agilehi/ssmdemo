package com.suftz.ssmdemo.mapper;


import com.suftz.ssmdemo.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author zhangchengy
 * @version 1.0
 * @date 2021/1/27 23:09
 */

public interface UserMapper {
//    @Select("select * from user where uid=#{uid}")
    public User getUserByUid(Integer uid);
    public User getUserByDeptId(Integer dept_id);

    public User getUserByUid2(Integer uid);

    public User getUserAndDept(Integer uid);

    public User getUserAndDept2(Integer uid);

    public Map<String,Object> getUserMapByUid(Integer uid);

    //mybatis增删改,也可以返回操作的结果
    public boolean addUser(User user);

    public boolean deleteUserByUid(Integer uid);

    public boolean updateUser(User user);

    public List<User> getAllUser();

    @MapKey("uid")
    public Map<Integer,User> getAllUserToMap();


    //-----------------------动态sql-----------

    public List<User> getUser(User user);
    public List<User> getUser2(User user);
    public List<User> getUser3(User user);
    public List<User> getUser4(User user);
    public List<User> getUser5(@Param("uids") List<Integer> list);

    public boolean addUsers(@Param("users") List<User> users);

    public boolean updateUserDynamic(User user);
    public boolean updateUserDynamic2(User user);

}
