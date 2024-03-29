package com.briup.cms.service.impl;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.ex.CategoryEx;
import com.briup.cms.dao.ICategoryDao;
import com.briup.cms.dao.ex.ICategoryExDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Autowired
    private ICategoryExDao categoryExDao;

    @Override
    public void saveOrUpdateCategory(Category category) throws CustomerException {

        if(category == null) {

            throw new CustomerException(CodeUtil.PARAM_NULL, "参数为空");
        }

        categoryDao.save(category);
    }

    @Override
    public void deleteCategoryById(int id) throws CustomerException {

        categoryDao.deleteById(id);
    }

    @Override
    public Category queryCategoryById(int id) throws CustomerException {

        return categoryDao.queryById(id);
    }

    @Override
    public List<Category> queryCategory() throws CustomerException {

        return categoryDao.findAll();
    }

    @Override
    public List<CategoryEx> findAllCategoryEx() throws CustomerException {

        return categoryExDao.findAll();
    }

}


