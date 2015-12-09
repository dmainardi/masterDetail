/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmainardi.masterDetail.presentation.container;

import com.dmainardi.masterDetail.business.boundary.ContainerService;
import com.dmainardi.masterDetail.business.entity.Container;
import com.dmainardi.masterDetail.business.entity.Element;
import java.io.Serializable;
import java.util.List;
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
