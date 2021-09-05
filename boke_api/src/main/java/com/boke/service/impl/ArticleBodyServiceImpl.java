package com.boke.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.mapper.ArticleBodyMapper;
import com.boke.pojo.ArticleBody;
import com.boke.service.ArticleBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyipeng
 * @date 2021-08-15 18:01
 */
@Service
public class ArticleBodyServiceImpl implements ArticleBodyService {

    @Autowired
    private ArticleBodyMapper articleBodyMapper;

    @Override
    public ArticleBody selectOne(LambdaQueryWrapper<ArticleBody> queryWrapper) {
        return articleBodyMapper.selectOne(queryWrapper);
    }

    @Override
    public void insert(ArticleBody articleBody) {
        articleBodyMapper.insert(articleBody);
    }
}
