package com.xzit.controller;

import com.xzit.model.Student;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api("学生管理")
public class StudentController {
    @GetMapping("/user")
    @ApiOperation("获取学生列表")
    public Object list(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"张三",23,"男"));
        students.add(new Student(2,"李四",20,"女"));
        students.add(new Student(3,"王五",21,"女"));
        students.add(new Student(4,"赵六",22,"男"));
        students.add(new Student(5,"孙权",22,"男"));
        return students;
    }
    @GetMapping("/user/{id}")
    @ApiOperation("按照id查找学生")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "学生id",dataType = "Integer",
                    dataTypeClass = Integer.class,
                    paramType = "path",
                    required = true)

    })
    public Object getStudentById(@PathVariable int id){
        return new Student(id,"晋某",19,"女");
    }
    @PostMapping ("/user")
    @ApiOperation("新增一个学生")

    public Object save(@RequestBody Student student){
     return student;
    }
    @PutMapping ("/user")
    @ApiOperation("更新一个学生")

    public Object update(@RequestBody Student student){
        return student;
    }
    @DeleteMapping("/user/{id}")
    @ApiOperation("按给定ID来删除学生信息")
    public Object deleteById(@ApiParam(name = "id",value = "学生id") @PathVariable int id){
        return "已删除给定id为"+id+"的学生对象";
    }
}
