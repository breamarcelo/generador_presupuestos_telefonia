package com.budgetsgenerator.services.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.mappers.impl.LineasAdicionalesMapper;
import com.budgetsgenerator.models.LineasAdicionalesEntity;
import com.budgetsgenerator.repository.impl.LineasAdicionalesDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

import jakarta.persistence.EntityManager;

public class LineasAdicionalesService extends GenericServiceImpl<LineasAdicionalesDTO, LineasAdicionalesMapper, LineasAdicionalesEntity, LineasAdicionalesDAO, Integer>{
    private static LineasAdicionalesService instance;
    
    private LineasAdicionalesService() {
        super(new LineasAdicionalesDAO(LineasAdicionalesEntity.class), LineasAdicionalesMapper.getInstance());
    }

    public static LineasAdicionalesService getInstance() {
        if(instance == null) {
            instance = new LineasAdicionalesService();
        }
        return instance;
    }

    public static void updateAll(List<LineasAdicionalesDTO> dtoList) {
        EntityManager em = JPAUtil.getEntityManager();
        LineasAdicionalesDAO lineasAdicionalesDAO = new LineasAdicionalesDAO(LineasAdicionalesEntity.class);
        LineasAdicionalesEntity entity = null;
        try {
            em.getTransaction().begin();
            for(LineasAdicionalesDTO dto : dtoList) {
                if(dto.getId() != null) {
                    entity = lineasAdicionalesDAO.findBy(dto.getId(), em);
                } else {
                    entity = new LineasAdicionalesEntity();
                }
                entity.setNombre(dto.getNombre());
                entity.setTipo(dto.getTipo());
                entity.setNumLineas(dto.getNumLineas());
                entity.setLlamadas(dto.getLlamadas());
                entity.setGb(dto.getGb());
                entity.setFibra(dto.getFibra());
                entity.setPrecio(dto.getPrecio());
                lineasAdicionalesDAO.update(entity, em);
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
