package com.boke.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boke.mapper.TagMapper;
import com.boke.pojo.Tag;
import com.boke.service.TagService;
import com.boke.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyipeng
 * @date 2021-08-15 10:28
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<TagVo> hot(int limit) {
        List<Integer> tagsId = tagMapper.findHotsTagIds(limit);
        List<Tag> tags = tagMapper.findTagsNameById(tagsId);
        List<TagVo> tagVos = copyList(tags);
        return tagVos;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        List<Tag> tags = tagMapper.findTagsByArticleId(id);
        return copyList(tags);
    }

    @Override
    public List<TagVo> findAll() {
        List<Tag> tags = tagMapper.selectList(new LambdaQueryWrapper<>());
        return copyList(tags);
    }

    @Override
    public List<TagVo> findAllDetial() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        List<Tag> tags = this.tagMapper.selectList(queryWrapper);
        return copyList(tags);
    }

    @Override
    public TagVo findDetialById(Long id) {
        Tag tag = tagMapper.selectById(id);
        return copy(tag);
    }

    private List<TagVo> copyList(List<Tag> tags) {
        List<TagVo> tagVos = new ArrayList<>();
        for (Tag tag : tags) {
            tagVos.add(copy(tag));
        }
        return tagVos;
    }

    private TagVo copy(Tag tag) {
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        tagVo.setId(tag.getId().toString());
        return tagVo;
    }
}
