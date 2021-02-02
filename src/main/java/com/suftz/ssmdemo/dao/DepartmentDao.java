package com.suftz.ssmdemo.dao;

import com.suftz.ssmdemo.bean.Department;
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
 * @date 2021/1/26 10:44
 */
@Repository(value="departmentDao")
public class DepartmentDao {

    public Department getDepartment(Integer id){
        return null;
    }

    public List<Department> getDepartments(){
        return null;
    }
}
