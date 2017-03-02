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

import com.dmainardi.masterDetail.business.entity.Container;
import com.dmainardi.masterDetail.business.entity.Element;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Davide Mainardi <ingmainardi@live.com>
 */
@Named
@ViewScoped
public class ElementPresenter implements Serializable {
    
    private boolean isElementNew;
    private Element element;
    private Container container;
    
    @PostConstruct
    public void init() {
        container = (Container) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("container");
        element = (Element) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("element");
        if (element == null) {
            element = new Element();
            isElementNew = true;
        }
        else
            isElementNew = false;
    }
    
    public String saveElement() {
        if (isElementNew) {
            element.setContainer(container);
            container.getElements().add(element);
        }
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("container", container);
        
        return "container?faces-redirect=true";
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
    
}
