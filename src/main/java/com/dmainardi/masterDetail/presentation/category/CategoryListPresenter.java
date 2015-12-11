/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmainardi.masterDetail.presentation.category;

import com.dmainardi.masterDetail.business.boundary.CategoryService;
import com.dmainardi.masterDetail.business.entity.Category;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Davide Mainardi <ingmainardi at live.com>
 */
@Named
@RequestScoped
public class CategoryListPresenter {
    
    @Inject
    CategoryService categoryService;

    public List<Category> listCategories() {
        return categoryService.listCategories();
    }
}
