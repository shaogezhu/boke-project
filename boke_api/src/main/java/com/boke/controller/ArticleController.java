package com.boke.controller;

import com.boke.common.aop.LogAnnotation;
import com.boke.common.cache.Cache;
import com.boke.pojo.Article;
import com.boke.service.ArticleService;
import com.boke.vo.Archives;
import com.boke.vo.ArticleVo;
import com.boke.vo.Result;
import com.boke.vo.params.ArticleParam;
import com.boke.vo.params.PageParams;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author liyipeng
 * @date 2021-08-15 0:52
 */
@RequestMapping("/articles")
@RestController
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping
    @LogAnnotation(module="文章",operation="分页查询文章列表")
    public Result articles(@RequestBody PageParams pageParams){
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);
        return Result.success(articles);
    }

    @PostMapping("/hot")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    public Result hotArticles(){
        int limit = 5;
        List<ArticleVo> articleVos = articleService.hotArticle(limit);
        return Result.success(articleVos);
    }

    @PostMapping("/new")
    @Cache(expire = 5 * 60 * 1000,name = "new_article")
    public Result newArticles(){
        int limit = 5;
        List<ArticleVo> articleVos = articleService.newArticles(limit);
        return Result.success(articleVos);
    }

    /**
     * 首页文章 归档
     * 按照年月显示文章
     */
    @PostMapping("listArchives")
    public Result listArchives(){
        List<Archives> archives = articleService.listArchives();
        return Result.success(archives);
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long id) {
        ArticleVo articleVo = articleService.findArticleById(id);
        return Result.success(articleVo);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        Map<String,String> articleVo = articleService.publish(articleParam);
        return Result.success(articleVo);
    }
}
