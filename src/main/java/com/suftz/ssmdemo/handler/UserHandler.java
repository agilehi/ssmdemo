package com.suftz.ssmdemo.handler;

import com.suftz.ssmdemo.bean.Department;
import com.suftz.ssmdemo.bean.User;

import com.suftz.ssmdemo.service.DepartmentService;
import com.suftz.ssmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author zhangchengy
 * @version 1.0
 * @date 2021/1/26 11:14
 */
@Controller
@RequestMapping(value="user")
public class UserHandler {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;

    public UserHandler(){
        System.out.println("userhandler");
    }

    @RequestMapping(value="list")
    public String userList(Map<String,Object> map){
        List<Department> list=departmentService.getDepartments();
        List<Department> departments=new ArrayList<>(list);//如果在部门的sql映射文件中对查询进行了二级缓存，这里每次拿到的就是相同地址空间的数据，
        //然鹅该list被添加了一个空对象如下。此时因为有二级缓存，则每访问一遍前端页面都会多添加空对象，
        //list.add(0,new Department(null,"请选择"));
        //map.put("departments",list);
        departments.add(0,new Department(null,"请选择"));
        map.put("departments",departments);
        map.put("users",userService.getUsers());
        map.put("user",new User());
        return "list";
    }

    @RequestMapping(value="save")
    public String userSave(@Valid User employee, BindingResult result,Map<String,Object> map){
        if(result.getErrorCount()>0){
            System.out.println("出错了");
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getField()+":"+error.getDefaultMessage());
            }
            List<Department> list=departmentService.getDepartments();
            List<Department> departments=new ArrayList<>(list);
            departments.add(0,new Department(null,"请选择"));
            map.put("departments",departments);
            map.put("users",userService.getUsers());
            map.put("user",employee);
            if(employee.getUid()==null){
                return "list";
            }else{
                return "edit";
            }
        }else{
            if(employee.getUid()==null){
                userService.add(employee);
            }else{
                userService.update(employee);
            }
        }
        return "redirect:/user/list";
    }

    @RequestMapping(value="delete")
    public String userDelete(Integer uid){
        userService.delete(uid);
        return "redirect:/user/list";
    }

    @RequestMapping(value="edit")
    public String userEdit(Integer uid,Map<String,Object> map){
        List<Department> list=departmentService.getDepartments();
        List<Department> departments=new ArrayList<>(list);
        departments.add(0,new Department(null,"请选择"));
        map.put("departments",departments);
        //map.put("users",userService.getUsers());
        User user= userService.get(uid);
        if(user==null){
            user=new User();
            user.setUid(uid);
        }
        map.put("user",user);
        return "edit";
    }

    @ResponseBody
    @RequestMapping(value="jsonlist")
    public Collection<User> userListToJson(){
        return userService.getUsers();
    }
}
