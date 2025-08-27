package com.xzit.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class Employee {

    private Integer id;
    private String empName;
    private String loginName;
    private String loginPassword;
    private Integer age;
    private String gender;
    private String addr;
    private String deptName;
    private Integer status;
    private Integer deleted;
}
