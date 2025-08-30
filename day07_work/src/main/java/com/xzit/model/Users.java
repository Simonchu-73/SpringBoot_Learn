package com.xzit.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.xzit.enums.StatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("users")
public class Users extends Model<Users> {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    @TableField(select = false)
    private String password;
    private StatusEnum status;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
