package com.xzit.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
@ConfigurationProperties(prefix = "com.xzit.model.Users")
public class Users {
    private int id;
    private String name;
    private String gender;
    private int age;
    private Date birthday;
}
