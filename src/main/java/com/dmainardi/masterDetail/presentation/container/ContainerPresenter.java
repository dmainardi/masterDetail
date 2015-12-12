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
@FlowScoped("container")
public class ContainerPresenter implements Serializable {
    @Inject
    ContainerService containerService;
    
    private Container container;
    
    private Element elementSelected;
    
    @PostConstruct
    public void init() {
        System.out.println("Entered container flow");
    }
    
    @PreDestroy
    public void clean() {
        System.out.println("Exited container flow");
    }
    
    public List<Container> listContainers() {
        return containerService.listContainers();
    }
        
    public void deleteContainer(Container container) {
        containerService.deleteContainer(container);
    }
    
    public String saveContainer() {
        containerService.saveContainer(container);
        
        return "containers";
    }
    
    public String detailContainer(Long id) {
        if (id == null)
            container = new Container();
        else
            container = containerService.readContainer(id);
        
        return "container";
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
    
    public List<Element> listElements() {
        return container.getElements();
    }
    
    public String saveElement() {
        if(elementSelected.getContainer() == null) {
            container.getElements().add(elementSelected);
            elementSelected.setContainer(container);
        }
        
        return "container";
    }
        
    public void deleteElement(Element element) {
        container.getElements().remove(element);
        element.setContainer(null);
    }
    
    public String detailElement(Element element) {
        if (element == null)
            elementSelected = new Element();
        else
            elementSelected = element;
        
        return "element";
    }

    public Element getElementSelected() {
        return elementSelected;
    }

    public void setElementSelected(Element elementSelected) {
        this.elementSelected = elementSelected;
    }
}
