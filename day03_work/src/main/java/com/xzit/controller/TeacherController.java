package com.xzit.controller;

import com.xzit.model.Student;
import com.xzit.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class TeacherController {
    private Teacher teacher;

    @Autowired
    public TeacherController(Teacher teacher) {
        this.teacher = teacher;
    }

    @GetMapping("/teacher")
    public Object getTeacher() {
        return teacher;
    }
    @GetMapping("/getAvg")
    public Object getAvgScores() {
        Map<String,Double> avgScores = new HashMap<>();


        List<Student> students = teacher.getStudents();
        for (Student student : students) {
            Map<String, Integer> scores = student.getScores();

            double avgScore = 0;
            int sum = 0;
            for (String s : scores.keySet()) {
                Integer score = scores.get(s);
                sum += score;
            }
            avgScore = sum / 3;
            avgScores.put(student.getStudentName(), avgScore);
        }
        return avgScores;
    }
    @GetMapping("/getChineseAvg")
    public Object getChineseAvgScores() {


        List<Student> students = teacher.getStudents();
        int sum = 0;
        for (Student student : students) {
            Map<String, Integer> scores = student.getScores();
            Integer chinese = scores.get("Chinese");
            System.out.println(chinese);
            sum+=chinese;

        }
        return sum/2;
    }
}
