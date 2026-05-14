package com.budgetsgenerator.services.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.mappers.impl.DescuentosMapper;
import com.budgetsgenerator.models.DescuentosEntity;
import com.budgetsgenerator.repository.impl.DescuentosDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

import jakarta.persistence.EntityManager;

public class DescuentosService extends GenericServiceImpl<DescuentosDTO, DescuentosMapper, DescuentosEntity, DescuentosDAO, Integer>{
    private static DescuentosService instance;

    private DescuentosService() {
        super(new DescuentosDAO(DescuentosEntity.class), DescuentosMapper.getInstance());
    }
    
    public static DescuentosService getInstance() {
        if(instance == null) {
            instance = new DescuentosService();
        }
        return instance;
    }

    public static void updateAll(List<DescuentosDTO> descuentos) {
        EntityManager em = JPAUtil.getEntityManager();
        DescuentosDAO descuentosDAO = new DescuentosDAO(DescuentosEntity.class);
        DescuentosEntity entity = null;
        try {
            em.getTransaction().begin();
            for(DescuentosDTO descuento :  descuentos) {
                if(descuento.getId() != null) {
                    entity = descuentosDAO.findBy(descuento.getId(), em);
                } else {
                    entity = new DescuentosEntity();
                }
                entity.setPorciento(descuento.getPorciento());
                descuentosDAO.update(entity, em);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
