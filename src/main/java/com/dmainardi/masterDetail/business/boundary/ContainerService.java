/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmainardi.masterDetail.business.boundary;

import com.dmainardi.masterDetail.business.entity.Container;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Davide Mainardi <ingmainardi at live.com>
 */
@Stateless
public class ContainerService {
    @PersistenceContext
    EntityManager em;
    
    public Container saveContainer(Container container) {
        if (container.getId() == null)
            em.persist(container);
        else
            return em.merge(container);
        
        return null;
    }
    
    public Container readContainer(Long id) {
        return em.find(Container.class, id);
    }
    
    public void deleteContainer(Container container) {
        em.remove(em.merge(container));
    }

    public List<Container> listContainers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Container> query = cb.createQuery(Container.class);
        Root<Container> root = query.from(Container.class);
        query.select(root);
        return em.createQuery(query).getResultList();
    }
}
