package com.online_pharmacies.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wang
 * @since 2024-09-12
 */
@Data
@TableName("user")
@ApiModel(value = "User对象")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("账号")
    @TableField("userno")
    @JsonAlias("adminNo")
    private String userno;

    @ApiModelProperty("名字")
    @TableField("name")
    private String name;

    @ApiModelProperty("密码")
    @TableField("password")
    @JsonAlias("adminPassword")
    private String password;

    @TableField("age")
    private Integer age;

    @ApiModelProperty("性别, 0为女, 1为男")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty("电话号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("角色 0超级管理员，1管理员，2普通账号")
    @TableField("role_id")
    private Integer roleId;
}
