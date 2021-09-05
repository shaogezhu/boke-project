package com.boke.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.mapper.ArticleMapper;
import com.boke.pojo.Article;
import com.boke.vo.params.CommentParam;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author liyipeng
 * @date 2021-08-15 23:54
 * 开启多线程用于更新文章的阅读数量
 */
@Component
public class ThreadService {


    @Async("taskExecutor")
    public void updateViewCount(ArticleMapper articleMapper, Article article){

        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(article.getViewCounts() + 1);
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId,article.getId());
        queryWrapper.eq(Article::getViewCounts,article.getViewCounts());
        articleMapper.update(articleUpdate,queryWrapper);
       /* try {
            //睡眠5秒 证明不会影响主线程的使用
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @Async("taskExecutor")
    public void updateCommentCount(ArticleMapper articleMapper, CommentParam commentParam){
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Article::getId,commentParam.getArticleId());
        lambdaQueryWrapper.last("limit 1");
        Article article = articleMapper.selectOne(lambdaQueryWrapper);

        Article articleUpdate = new Article();
        articleUpdate.setCommentCounts(article.getCommentCounts() + 1);
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId,article.getId());
        queryWrapper.eq(Article::getCommentCounts,article.getCommentCounts());
        articleMapper.update(articleUpdate,queryWrapper);
    }
}
