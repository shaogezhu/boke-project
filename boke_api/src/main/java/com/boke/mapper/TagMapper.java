package com.boke.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boke.pojo.Tag;

import java.util.List;

/**
 * @author liyipeng
 * @date 2021-08-15 1:45
 */
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> findTagsByArticleId(Long id);

    List<Integer> findHotsTagIds(int limit);

    List<Tag> findTagsNameById(List<Integer> tagIds);

}
