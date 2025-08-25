package com.xzit.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "com.xzit.model.teacher")

public class Teacher {
    private String teacherName;
    private String teacherGender;
    private int teacherAge;
    List<Student> students;
}
