package com.xzit.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("employee")
public class Employee {

    private Integer id;
    private String empName;
    private String loginName;
    @TableField(select = false)
    private String loginPassword;
    private Integer age;
    private String gender;
    private String addr;
    private String deptName;
    private Integer status;
    private Integer deleted;
}
