package com.xzit.generator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author SimonChu
 * @since 2025-09-03
 */
@Data
@Accessors(chain = true)

public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;


    private String cname;


    private String channelDesc;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    private Boolean deleted;
}
