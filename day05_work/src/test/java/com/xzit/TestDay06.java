package com.xzit;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzit.mapper.EmployeeMapper;
import com.xzit.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestDay06 {
    @Resource
    EmployeeMapper employeeMapper;

    @Test
    public void testQuestion1() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(Employee::getAge, 22).le(Employee::getAge, 30).eq(Employee::getGender, "男");
        List<Employee> list = employeeMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testQuestion2() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getGender, "女").and(
                i -> i.eq(Employee::getDeptName, "销售部").or().eq(Employee::getDeptName, "市场部"));
        List<Employee> list = employeeMapper.selectList(wrapper);
    }

    @Test
    public void testQuestion3() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getStatus,1).likeRight(Employee::getAddr,"长春市");
        List<Employee> list = employeeMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }
    @Test
    public void testQuestion4() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Employee::getLoginName,"admin")
                .and(i->i.eq(Employee::getGender,"男")
                        .or()
                        .eq(Employee::getDeptName,"人事部"));
        List<Employee> list = employeeMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }
    @Test
    public void testQuestion5() {
        Page page = new Page(2,5);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        Page selectPage = employeeMapper.selectPage(page, wrapper);
        selectPage.getRecords().forEach(System.out::println);

    }
}
