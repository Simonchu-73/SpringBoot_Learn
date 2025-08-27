package com.xzit.service;

import com.xzit.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    int insert(Employee employee);
    int deleteById(Integer id);
    int updateById(Employee employee);
    List<Employee> selectList();
    Employee selectById(Integer id);
}
