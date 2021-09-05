package com.boke.service;

import com.boke.pojo.Comment;
import com.boke.vo.CommentVo;
import com.boke.vo.Result;
import com.boke.vo.params.CommentParam;

import java.util.List;

/**
 * @author liyipeng
 * @date 2021-08-16 0:25
 */
public interface CommentsService {
    List<CommentVo> commentsByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}
