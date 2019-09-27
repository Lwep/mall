package com.leqi.admin.service.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.leqi.common.core.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author lwep
 * @dareTime 2019/9/3 16:33
 */
@Data
@TableName("mall_admin")
@ApiModel("管理员实体")
public class Admin extends BaseEntity {

    @NotNull(message = "用户名不能为空")
    @ApiModelProperty(value = "管理员名称",name="usernmae",dataType ="String" )

    private String username;

    private String password;
    private String realname;
    private String phone;
    private int status;

}
