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
package com.dmainardi.masterDetail.presentation.container;

import com.dmainardi.masterDetail.business.boundary.ContainerService;
import com.dmainardi.masterDetail.business.entity.Container;
import com.dmainardi.masterDetail.business.entity.Element;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Davide Mainardi <ingmainardi at live.com>
 */
@Named
@ViewScoped
public class ContainerPresenter implements Serializable {
    @Inject
    ContainerService service;
    
    private Container container;
    private Long id;
    
    public String saveContainer() {
        service.saveContainer(container);
        
        return "/container/containers?faces-redirect=true";
    }
    
    @PostConstruct
    public void init() {
        container = (Container) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("container");
    }
    
    public void detailContainer() {
        if (container == null && id != null) {
            if (id == 0)
                container = new Container();
            else
                container = service.readContainer(id);
            id = null;
        }
    }
    
    public String detailElement(Element element) {
        if (element != null)
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("element", element);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("container", container);
        
        return "element?faces-redirect=true";
    }
    
    public void deleteElement(Element element) {
        if (element != null) {
            container.getElements().remove(element);
            element.setContainer(null);
        }
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
