package com.xzit.service;

import com.xzit.mapper.EmployeeMapper;
import com.xzit.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public int deleteById(Integer id) {
        return employeeMapper.deleteById(id);
    }

    @Override
    public int updateById(Employee employee) {
        return employeeMapper.updateById(employee);
    }

    @Override
    public List<Employee> selectList() {
        return employeeMapper.selectList();
    }

    @Override
    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }
}
