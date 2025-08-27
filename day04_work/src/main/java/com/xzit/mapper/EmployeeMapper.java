package com.xzit.mapper;


import com.xzit.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeMapper {
    int insert(Employee employee);
    int deleteById(Integer id);
    int updateById(Employee employee);
    List<Employee> selectList();
    Employee selectById(Integer id);
}
