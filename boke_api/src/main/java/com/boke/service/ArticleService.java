package com.boke.service;

import com.boke.vo.Archives;
import com.boke.vo.ArticleVo;
import com.boke.vo.Result;
import com.boke.vo.params.ArticleParam;
import com.boke.vo.params.PageParams;

import java.util.List;
import java.util.Map;

/**
 * @author liyipeng
 * @date 2021-08-15 1:07
 */
public interface ArticleService {
    List<ArticleVo> listArticlesPage(PageParams pageParams);

    List<ArticleVo> hotArticle(int limit);

    List<ArticleVo> newArticles(int limit);

    List<Archives> listArchives();

    ArticleVo findArticleById(Long id);

    Map<String,String> publish(ArticleParam articleParam);
}
