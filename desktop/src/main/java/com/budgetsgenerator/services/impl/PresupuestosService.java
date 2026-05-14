package com.budgetsgenerator.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.mappers.impl.LineasPresupuestoMapper;
import com.budgetsgenerator.mappers.impl.PresupuestosMapper;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.impl.PresupuestosDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

import jakarta.persistence.EntityManager;

public class PresupuestosService extends GenericServiceImpl<PresupuestosDTO, PresupuestosMapper, PresupuestosEntity, PresupuestosDTO, Integer>{
    private static PresupuestosService instance;

    private PresupuestosService() {
        super(new PresupuestosDAO(PresupuestosEntity.class), PresupuestosMapper.getInstance());
    }

    public static PresupuestosService getInstance() {
        if(instance == null) {
            instance = new PresupuestosService();
        }
        return instance;
    }
    
    public static PresupuestosDTO savePresupuesto(PresupuestosDTO presupuestosDTO, List<LineasPresupuestoDTO> lineasPresupuesto){
        EntityManager em = JPAUtil.getEntityManager();
        PresupuestosDAO presupuestosDAO = new PresupuestosDAO(PresupuestosEntity.class);
        
        try {
            em.getTransaction().begin();
            PresupuestosEntity presupuestosEntity = PresupuestosMapper.getInstance().toEntity(presupuestosDTO, em);
            presupuestosEntity.setLineasPresupuesto(new ArrayList<>());
    
            List<LineasPresupuestoEntity> lineasPresupuestoEntitys = LineasPresupuestoMapper.getInstance().toEntityList(lineasPresupuesto, em);
            PresupuestosEntity savedEntity = presupuestosDAO.savePresupuesto(presupuestosEntity, lineasPresupuestoEntitys, em);
            em.getTransaction().commit();
            return PresupuestosMapper.getInstance().toDTO(savedEntity, em);
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            throw e;  
        } finally {
            em.close();
        }
    }

    public static PresupuestosDTO updatePresupuesto(PresupuestosDTO presupuestosDTO, List<LineasPresupuestoDTO> lineasPresupuesto){
        EntityManager em = JPAUtil.getEntityManager();
        PresupuestosDAO presupuestosDAO = new PresupuestosDAO(PresupuestosEntity.class);
        
        try {
            em.getTransaction().begin();
            PresupuestosEntity presupuestosEntity = em.find(PresupuestosEntity.class, presupuestosDTO.getId());
            List<LineasPresupuestoEntity> lineasPresupuestoEntitys = LineasPresupuestoMapper.getInstance().toEntityList(lineasPresupuesto, em);
            PresupuestosEntity updated = presupuestosDAO.updatePresupuesto(presupuestosDTO, presupuestosEntity, lineasPresupuestoEntitys, em);
            em.getTransaction().commit();
            return PresupuestosMapper.getInstance().toDTO(updated, em);
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
