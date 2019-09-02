package com.leqi.common.core;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author lwep
 * @dareTime 2019/8/31 9:37
 */
@Data
public class BaseEntity {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDate createTime;
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDate updateTime;
}
