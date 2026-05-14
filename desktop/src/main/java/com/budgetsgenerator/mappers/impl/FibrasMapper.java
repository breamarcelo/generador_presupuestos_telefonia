package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.FibrasEntity;
import com.budgetsgenerator.repository.impl.FibrasDAO;

import jakarta.persistence.EntityManager;

public class FibrasMapper implements EntityMapper<FibrasEntity, FibrasDTO, EntityManager>{
    private static final FibrasMapper instance = new FibrasMapper();
    private static final FibrasDAO fibrasDAO = new FibrasDAO(FibrasEntity.class);

    private FibrasMapper() {
    }

    public static FibrasMapper getInstance(){
        return instance;
    }

    @Override
    public FibrasDTO toDTO(FibrasEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        FibrasDTO dto = new FibrasDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setSobrecargo(entity.getSobrecargo());
        return dto;
    }
    
    @Override
    public FibrasEntity toEntity(FibrasDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        } 
        FibrasEntity entity = new FibrasEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setSobrecargo(dto.getSobrecargo());
        return entity;
    }

    @Override
    public List<FibrasEntity> toEntityList(List<FibrasDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<FibrasEntity> entitys = new ArrayList<>();
            for(FibrasDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return fibrasDAO.findall(em);
    }

    @Override
    public List<FibrasDTO> toDTOList(List<FibrasEntity> entities, EntityManager em) {
        if(entities == null) {
            entities = fibrasDAO.findall(em);
        }
        List<FibrasDTO> dtos = new ArrayList<>();
        for(FibrasEntity entity : entities){
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
    
}
