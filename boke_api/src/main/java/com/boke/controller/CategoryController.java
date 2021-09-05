package com.boke.controller;

import com.boke.pojo.Category;
import com.boke.service.CategoryService;
import com.boke.vo.CategoryVo;
import com.boke.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liyipeng
 * @date 2021-08-16 10:01
 */
@RequestMapping("categorys")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result listCategory() {
        List<CategoryVo> categoryList= categoryService.findAll();
        return Result.success(categoryList);
    }


    @GetMapping("detail")
    public Result listCategoryDetail() {
        List<CategoryVo> categoryList= categoryService.findAllDetail();
        return Result.success(categoryList);
    }

    //detail/{id}
    @GetMapping("detail/{id}")
    public Result findDetailById(@PathVariable("id") Long id) {
        CategoryVo category= categoryService.findDetailById(id);
        return Result.success(category);
    }

}
