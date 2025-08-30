package com.xzit.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzit.mapper.EmployeeMapper;
import com.xzit.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
}
