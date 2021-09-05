package com.boke.controller;

import com.boke.pojo.Comment;
import com.boke.service.CommentsService;
import com.boke.vo.CommentVo;
import com.boke.vo.Result;
import com.boke.vo.params.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyipeng
 * @date 2021-08-16 0:23
 */
@RequestMapping("comments")
@RestController
public class CommentController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("article/{id}")
    public Result comments(@PathVariable("id") Long articleId){
        List<CommentVo> commentList = commentsService.commentsByArticleId(articleId);
        return Result.success(commentList);
    }

    @PostMapping("create/change")
    public Result comment(@RequestBody CommentParam commentParam){
        return commentsService.comment(commentParam);
    }


}
