/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmainardi.masterDetail.presentation.category;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

/**
 *
 * @author Davide Mainardi <ingmainardi at live.com>
 */
public class CategoryFlow {
    
    @Produces
    @FlowDefinition
    public Flow defineCategoryFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        flowBuilder.id("", "category");
        
        flowBuilder.viewNode("list", "/category/categories.xhtml").markAsStartNode();
        flowBuilder.viewNode("detail", "/category/category.xhtml");
        
        flowBuilder.returnNode("index").fromOutcome("index");
        
        return flowBuilder.getFlow();
    }
}
