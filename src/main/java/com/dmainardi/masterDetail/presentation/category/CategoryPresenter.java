/*
 * Copyright (C) 2015 Davide Mainardi <ingmainardi at live.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.dmainardi.masterDetail.presentation.category;

import com.dmainardi.masterDetail.business.boundary.CategoryService;
import com.dmainardi.masterDetail.business.entity.Category;
import java.io.Serializable;
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
        System.out.println("Entered category flow");
    }
    
    @PreDestroy
    public void clean() {
        System.out.println("Exited category flow");
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
