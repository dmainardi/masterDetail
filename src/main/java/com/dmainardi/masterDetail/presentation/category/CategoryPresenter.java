/*
 * Copyright (C) 2015 Davide Mainardi <ingmainardi at live.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.dmainardi.masterDetail.presentation.category;

import com.dmainardi.masterDetail.business.boundary.CategoryService;
import com.dmainardi.masterDetail.business.entity.Category;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Davide Mainardi <ingmainardi at live.com>
 */
@Named
@FlowScoped("category")
public class CategoryPresenter implements Serializable {
    @Inject
    CategoryService categoryService;
    
    private Category category;
    
    @PostConstruct
    public void init() {
        System.out.println("Entrato");
    }
    
    @PreDestroy
    public void clean() {
        System.out.println("Uscito");
    }
    
    public List<Category> listCategories() {
        return categoryService.listCategories();
    }
        
    public void deleteCategory(Category category) {
        categoryService.deleteCategory(category);
    }
    
    public String saveCategory() {
        categoryService.saveCategory(category);
        
        return "categories";
    }
    
    public String detailCategory(Long id) {
        if (id == null)
            category = new Category();
        else
            category = categoryService.readCategory(id);
        
        return "category";
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
