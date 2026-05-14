package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.DescuentosEntity;
import com.budgetsgenerator.repository.impl.DescuentosDAO;

import jakarta.persistence.EntityManager;

public class DescuentosMapper implements EntityMapper<DescuentosEntity, DescuentosDTO, EntityManager> {
    private static final DescuentosMapper instance = new DescuentosMapper();
    private static final DescuentosDAO descuentosDAO = new DescuentosDAO(DescuentosEntity.class);

    private DescuentosMapper(){
    }

    public static DescuentosMapper getInstance(){
        return instance;
    }
    
    @Override
    public DescuentosDTO toDTO(DescuentosEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        DescuentosDTO dto = new DescuentosDTO();
        dto.setId(entity.getId());
        dto.setPorciento(entity.getPorciento());
        return dto;
    }

    @Override
    public DescuentosEntity toEntity(DescuentosDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        } 
        DescuentosEntity entity = new DescuentosEntity();
        entity.setId(dto.getId());
        entity.setPorciento(dto.getPorciento());
        return entity;
    }

    @Override
    public List<DescuentosEntity> toEntityList(List<DescuentosDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<DescuentosEntity> entitys = new ArrayList<>();
            for(DescuentosDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return descuentosDAO.findall(em);
    }

    @Override
    public List<DescuentosDTO> toDTOList(List<DescuentosEntity> entities, EntityManager em) {
        if(entities == null){
            entities = descuentosDAO.findall(em);
        }
        List<DescuentosDTO> dtos = new ArrayList<>();
        for(DescuentosEntity entity : entities) {
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }

}
