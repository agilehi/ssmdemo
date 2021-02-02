package com.suftz.ssmdemo.mapper;


import com.suftz.ssmdemo.bean.Department;

import java.util.List;

/**
 * Description:
 *
 * @author zhangchengy
 * @version 1.0
 * @date 2021/1/28 22:25
 */

public interface DepartmentMapper {
    public Department getDeptById(Integer id);
    public List<Department> getDepts();
    public Department getDeptUsersById(Integer id);
    public Department getDeptUsersById2(Integer id);
}
