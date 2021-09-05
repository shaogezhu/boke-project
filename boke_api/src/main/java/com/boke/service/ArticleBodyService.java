package com.boke.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boke.pojo.ArticleBody;

/**
 * @author liyipeng
 * @date 2021-08-15 17:52
 */
public interface ArticleBodyService {
    ArticleBody selectOne(LambdaQueryWrapper<ArticleBody> queryWrapper);

    void insert(ArticleBody articleBody);
}
