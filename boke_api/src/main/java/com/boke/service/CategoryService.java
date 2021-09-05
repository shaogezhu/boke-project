package com.boke.service;

import com.boke.pojo.Category;
import com.boke.vo.CategoryVo;

import java.util.List;

/**
 * @author liyipeng
 * @date 2021-08-15 17:49
 */
public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    List<CategoryVo> findAll();

    List<CategoryVo> findAllDetail();

    CategoryVo findDetailById(Long id);
}
