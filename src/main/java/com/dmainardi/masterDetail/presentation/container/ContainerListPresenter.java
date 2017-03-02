/*
 * Copyright (C) 2017 Davide Mainardi <ingmainardi@live.com>
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
package com.dmainardi.masterDetail.presentation.container;

import com.dmainardi.masterDetail.business.boundary.ContainerService;
import com.dmainardi.masterDetail.business.entity.Container;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Davide Mainardi <ingmainardi@live.com>
 */
@Named
@RequestScoped
public class ContainerListPresenter {
    @Inject
    ContainerService service;
    
    private List<Container> containers;

    @PostConstruct
    public void init() {
        containers = service.listContainers();
    }

    public List<Container> getContainers() {
        return containers;
    }
    
    public void deleteContainer(Long id) {
        if (id != null) {
            service.deleteContainer(id);
            containers = service.listContainers();
        }
    }
}
