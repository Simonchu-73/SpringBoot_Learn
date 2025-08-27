package com.xzit;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xzit.mapper.EmployeeMapper;
import com.xzit.model.Employee;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppTest {
    @Resource
    EmployeeMapper employeeMapper;

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setId(16).setEmpName("张居正").setLoginName("zhangjuzheng").setLoginPassword("123456")
                .setAge(35).setAddr("北京市朝阳区").setDeptName("人力资源部").setGender("男");
        employeeMapper.insert(employee);
    }

    @Test
    public void testSelectList() {
        List<Employee> list = employeeMapper.selectList(null);
    }

    @Test
    public void testUpdateOne() {
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Employee::getDeptName, "销售部").eq(Employee::getDeptName, "市场部");
        employeeMapper.update(null, wrapper);
    }

    @Test
    public void testUpdateTwo() {
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Employee::getStatus, 1).notIn(Employee::getAge, 30, 50).
                likeRight(Employee::getAddr, "吉林市").or().likeRight(Employee::getAddr, "长春市");
        employeeMapper.update(null, wrapper);
    }

    @Test
    public void testDelete() {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.ge("age",60).eq("gender","男");
        employeeMapper.delete(wrapper);



    }
}
