package com.suftz.ssmdemo.service;

import com.suftz.ssmdemo.bean.Department;
import com.suftz.ssmdemo.dao.DepartmentDao;
import com.suftz.ssmdemo.mapper.DepartmentMapper;
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
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public DepartmentService() {
        System.out.println("DepartmentService...");
    }

    public Department getDepartment(Integer id){
        return departmentMapper.getDeptById(id);
    }

    public List<Department> getDepartments(){
        return departmentMapper.getDepts();
    }
}
