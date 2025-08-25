package com.xzit.model;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component

public class Student {
    private String studentName;
    private String studentGender;
    private int studentAge;
    private Map<String,Integer> scores;
}
