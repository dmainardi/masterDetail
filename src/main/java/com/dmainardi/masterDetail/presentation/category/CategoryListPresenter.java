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
import java.util.List;
import javax.annotation.PostConstruct;
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
    CategoryService service;
    
    private List<Category> categories;

    @PostConstruct
    public void init() {
        categories = service.listCategories();
    }

    public List<Category> getCategories() {
        return categories;
    }
    
    public void deleteCategory(Long id) {
        if (id != null) {
            service.deleteCategory(id);
            categories = service.listCategories();
        }
    }
}
