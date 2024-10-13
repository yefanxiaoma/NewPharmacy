package com.online_pharmacies.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wang
 * @since 2024-10-08
 */
@Getter
@Setter
@TableName("menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("菜单编码")
    @TableField("menuCode")
    private String menuCode;

    @ApiModelProperty("菜单名字")
    @TableField("menuName")
    private String menuName;

    @ApiModelProperty("菜单级别")
    @TableField("menuLevel")
    private String menuLevel;

    @ApiModelProperty("菜单的父code")
    @TableField("menuParentCode")
    private String menuParentCode;

    @ApiModelProperty("点击触发的函数")
    @TableField("menuClick")
    private String menuClick;

    @ApiModelProperty("权限 0为超级管理员，1为管理员")
    @TableField("menuRight")
    private String menuRight;

    @TableField("menuComponent")
    private String menuComponent;

    @TableField("menuIcon")
    private String menuIcon;
}
