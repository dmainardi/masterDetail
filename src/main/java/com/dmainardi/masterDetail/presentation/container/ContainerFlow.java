/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmainardi.masterDetail.presentation.container;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

/**
 *
 * @author Davide Mainardi <ingmainardi at live.com>
 */
public class ContainerFlow {
    
    @Produces
    @FlowDefinition
    public Flow defineContainerFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        flowBuilder.id("", "container");
        
        flowBuilder.viewNode("list", "/container/containers.xhtml").markAsStartNode();
        //flowBuilder.viewNode("detail", "/container/container.xhtml");
        //flowBuilder.viewNode("elementDetail", "/container/element.xhtml");
        
        flowBuilder.returnNode("exitFlow").fromOutcome("/index");
        
        return flowBuilder.getFlow();
    }
}
