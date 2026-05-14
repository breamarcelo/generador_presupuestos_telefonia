package com.budgetsgenerator.services.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.mappers.impl.CentralitasMapper;
import com.budgetsgenerator.models.CentralitasEntity;
import com.budgetsgenerator.repository.impl.CentralitasDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

import jakarta.persistence.EntityManager;

public class CentralitasService extends GenericServiceImpl<CentralitasDTO, CentralitasMapper, CentralitasEntity, CentralitasDAO, Integer>{
    private static CentralitasService instance;

    private CentralitasService() {
        super(new CentralitasDAO(CentralitasEntity.class), CentralitasMapper.getInstance());
    }
   
    public static CentralitasService getInstance(){
        if(instance == null) {
            instance = new CentralitasService();
        }
        return instance;
    }

    public static void updateAll(List<CentralitasDTO> dtos) {
        EntityManager em = JPAUtil.getEntityManager();
        CentralitasDAO centralitasDAO = new CentralitasDAO(CentralitasEntity.class);
        CentralitasEntity entity = null;
        try {
            em.getTransaction().begin();
            for(CentralitasDTO dto : dtos) {
                if(dto.getId() != null) {
                    entity = centralitasDAO.findBy(dto.getId(), em);
                } else {
                    entity = new CentralitasEntity();
                }
                entity.setNombre(dto.getNombre());
                entity.setPrecio(dto.getPrecio());
                centralitasDAO.update(entity, em);
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
