package com.boke.service;

import com.boke.pojo.Tag;
import com.boke.vo.TagVo;

import java.util.List;

/**
 * @author liyipeng
 * @date 2021-08-15 10:28
 */
public interface TagService {
    List<TagVo> hot(int limit);
    List<TagVo> findTagsByArticleId(Long id);

    List<TagVo> findAll();

    List<TagVo> findAllDetial();

    TagVo findDetialById(Long id);
}
