package com.budgetsgenerator.services.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.mappers.impl.StreamingMapper;
import com.budgetsgenerator.models.StreamingEntity;
import com.budgetsgenerator.repository.impl.StreamingDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

import jakarta.persistence.EntityManager;

public class StreamingService extends GenericServiceImpl<StreamingDTO, StreamingMapper, StreamingEntity, StreamingDAO, Integer>{
    private static StreamingService instance;

    private StreamingService() {
        super(new StreamingDAO(StreamingEntity.class), StreamingMapper.getInstance());
    }

    public static StreamingService getInstance() {
        if(instance == null) {
            instance = new StreamingService();
        }
        return instance;
    }

    public static void updateAll(List<StreamingDTO> dtos) {
        EntityManager em = JPAUtil.getEntityManager();
        StreamingDAO streamingDAO = new StreamingDAO(StreamingEntity.class);
        StreamingEntity entity = null;
        try {
            em.getTransaction().begin();
            for(StreamingDTO dto : dtos) {
                if(dto.getId() != null) {
                    entity = streamingDAO.findBy(dto.getId(), em);
                } else {
                    entity = new StreamingEntity();
                }
                entity.setNombre(dto.getNombre());
                streamingDAO.update(entity, em);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

}
