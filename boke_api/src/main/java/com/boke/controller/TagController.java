package com.boke.controller;

import com.boke.pojo.Tag;
import com.boke.service.TagService;
import com.boke.vo.Result;
import com.boke.vo.TagVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author liyipeng
 * @date 2021-08-15 10:26
 */
@RequestMapping("tags")
@RestController
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/hot")
    public Result tagesHot(){
        int limit = 6;
        List<TagVo> tages= tagService.hot(limit);
        return Result.success(tages);
    }

    @GetMapping
    public Result findAll(){
        List<TagVo> tagVos = tagService.findAll();
        return Result.success(tagVos);
    }
    //detail

    @GetMapping("detail")
    public Result findAllDetial(){
        List<TagVo> tagVos = tagService.findAllDetial();
        return Result.success(tagVos);
    }

    @GetMapping("detail/{id}")
    public Result findDetialById(@PathVariable("id") Long id){
        TagVo tagVo = tagService.findDetialById(id);
        return Result.success(tagVo);
    }
}
