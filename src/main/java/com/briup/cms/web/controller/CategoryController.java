package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(description = "栏目管理")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/add")
    @ApiOperation("添加栏目")
    public Message addCategory(Category category) {
        categoryService.saveOrUpdateCategory(category);

        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation("删除栏目")
    @ApiImplicitParam(name = "id" , value = "栏目id" , paramType = "query" , dataType = "int" , required = true)
    public Message deleteCategoryById(int id) {

        categoryService.deleteCategoryById(id);

        return  MessageUtil.success();
    }

    @GetMapping("queryById")
    @ApiOperation("查询栏目")
    @ApiImplicitParam(name = "id" , value = "栏目id" , paramType = "query" , dataType = "int" , required = true)
    public Message<Category> queryCategoryById(int id) {

        Category category = categoryService.queryCategoryById(id);

        return MessageUtil.success(category);
    }

    @PostMapping("update")
    @ApiOperation("更新栏目")
    public Message update(Category category) {

        categoryService.saveOrUpdateCategory(category);

        return MessageUtil.success();
    }

    @GetMapping("/query")
    @ApiOperation("查询所有栏目")
    public Message<List<Category>> queryCategory() {

        List<Category> categories = categoryService.queryCategory();

        return MessageUtil.success(categories);
    }



}
