package com.budgetsgenerator.services.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.mappers.impl.PacksFutbolMapper;
import com.budgetsgenerator.models.PacksFutbolEntity;
import com.budgetsgenerator.repository.impl.PacksFutbolDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

import jakarta.persistence.EntityManager;

public class PacksFutbolService extends GenericServiceImpl<PacksFutbolDTO, PacksFutbolMapper, PacksFutbolEntity, PacksFutbolDAO, Integer>{
    private static PacksFutbolService instance;

    private PacksFutbolService() {
        super(new PacksFutbolDAO(PacksFutbolEntity.class), PacksFutbolMapper.getInstance());
    }

    public static PacksFutbolService getInstance() {
        if(instance == null) {
            instance = new PacksFutbolService();
        }
        return instance;
    }

    public static void updateAll(List<PacksFutbolDTO> dtos) {
        EntityManager em = JPAUtil.getEntityManager();
        PacksFutbolDAO packsFutbolDAO = new PacksFutbolDAO(PacksFutbolEntity.class);
        PacksFutbolEntity entity = null;
        try {
            em.getTransaction().begin();
            for(PacksFutbolDTO dto : dtos) {
                if(dto.getId() != null) {
                    entity = packsFutbolDAO.findBy(dto.getId(), em);
                } else {
                    entity = new PacksFutbolEntity();
                }
                entity.setNombre(dto.getNombre());
                entity.setPrecio(dto.getPrecio());
                packsFutbolDAO.update(entity, em);
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
