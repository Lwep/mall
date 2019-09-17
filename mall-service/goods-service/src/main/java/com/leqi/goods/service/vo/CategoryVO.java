package com.leqi.goods.service.vo;

import lombok.Data;

import java.util.List;

/**
 * @author lwep
 * @dareTime 2019/9/11 17:04
 */
@Data
public class CategoryVO {
    private String value;
    private String label;
    private List<CategoryVO> children;
}
