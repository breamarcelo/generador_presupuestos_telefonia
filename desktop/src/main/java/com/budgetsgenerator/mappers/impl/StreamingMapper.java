package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.StreamingDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.StreamingEntity;
import com.budgetsgenerator.repository.impl.StreamingDAO;

import jakarta.persistence.EntityManager;

public class StreamingMapper implements EntityMapper<StreamingEntity, StreamingDTO, EntityManager>{
    private static final StreamingMapper instance = new StreamingMapper();
    private static final StreamingDAO streamingDAO = new StreamingDAO(StreamingEntity.class);
    
    private StreamingMapper() {
    }

    public static StreamingMapper getInstance() {
        return instance;
    }
    
    @Override
    public StreamingDTO toDTO(StreamingEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        StreamingDTO dto = new StreamingDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    @Override
    public StreamingEntity toEntity(StreamingDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        }
        StreamingEntity entity = new StreamingEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    @Override
    public List<StreamingEntity> toEntityList(List<StreamingDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<StreamingEntity> entitys = new ArrayList<>();
            for(StreamingDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return streamingDAO.findall(em);
    }
  
    @Override
    public List<StreamingDTO> toDTOList(List<StreamingEntity> entities, EntityManager em) {
        if(entities == null) {
            entities = streamingDAO.findall(em);
        }
        List<StreamingDTO> dtos = new ArrayList<>();
        for(StreamingEntity entity : entities){
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
    
}
