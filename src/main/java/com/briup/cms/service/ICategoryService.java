package com.briup.cms.service;

import com.briup.cms.bean.Category;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface ICategoryService {

    void saveOrUpdateCategory(Category category) throws CustomerException;

    void deleteCategoryById(int id) throws CustomerException;

    Category queryCategoryById(int id) throws CustomerException;

    List<Category> queryCategory() throws CustomerException;


}
