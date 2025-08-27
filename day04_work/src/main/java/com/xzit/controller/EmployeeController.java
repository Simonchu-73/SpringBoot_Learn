package com.xzit.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.model.Employee;
import com.xzit.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("employee")
@Api(tags = "员工管理")
public class EmployeeController {

    @Resource
    EmployeeService employeeServiceImpl;

    @GetMapping
    @ApiOperation("显示所有员工信息")
    public Object selectList() {
        return employeeServiceImpl.selectList();
    }
    @GetMapping("/{id}")
    @ApiOperation("按照id查询员工信息")
    public Object selectById(@PathVariable Integer id) {
        return employeeServiceImpl.selectById(id);
    }
    @GetMapping("/{start}/{size}")
    @ApiOperation("分页显示所有员工信息")
    public Object selectPage(@PathVariable Integer start, @PathVariable Integer size) {
        PageHelper.startPage(start, size);
        List<Employee> employees = employeeServiceImpl.selectList();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        return pageInfo;
    }
    @PutMapping
    @ApiOperation("按照id更新")
    public  Object update(@RequestBody Employee employee) {
       return employeeServiceImpl.updateById(employee);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("按照id删除")
    public Object deleteById(@PathVariable Integer id) {
        int i = employeeServiceImpl.deleteById(id);
        return i;
    }


}
