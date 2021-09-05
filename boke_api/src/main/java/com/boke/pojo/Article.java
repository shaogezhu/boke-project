package com.boke.pojo;

import lombok.Data;

/**
 * @author liyipeng
 * @date 2021-08-15 0:53
 * 文章表的对应pojo类
 */
@Data
public class Article {

    public static final int Article_TOP = 1;

    public static final int Article_Common = 0;

    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 简介
     */
    private String summary;
    /**
     * 评论数量
     */
    private Integer commentCounts;
    /**
     * 浏览数量
     */
    private Integer viewCounts;

    /**
     * 作者id
     */
    private Long authorId;
    /**
     * 内容id
     */
    private Long bodyId;
    /**
     *类别id
     */
    private Long categoryId;

    /**
     * 置顶
     */
    private Integer weight;


    /**
     * 创建时间
     */
    private Long createDate;
}
