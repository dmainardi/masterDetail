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
