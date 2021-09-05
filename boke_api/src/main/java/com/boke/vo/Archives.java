package com.boke.vo;

import lombok.Data;

/**
 * @author liyipeng
 * @date 2021-08-15 11:27
 * 返回给前端用于归档的数据
 * 显示每年 每月多少片文章
 */
@Data
public class Archives {

    private Integer year;

    private Integer month;

    private Integer count;
}
