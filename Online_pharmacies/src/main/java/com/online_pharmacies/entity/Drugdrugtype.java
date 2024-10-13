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
 * @since 2024-10-12
 */
@Getter
@Setter
@TableName("drugdrugtype")
@ApiModel(value = "Drugdrugtype对象", description = "")
public class Drugdrugtype implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ddt_id", type = IdType.AUTO)
    private Integer ddtId;

    @TableField("medication_f_id")
    private Integer medicationFId;

    @TableField("type_f_id")
    private Integer typeFId;
}
