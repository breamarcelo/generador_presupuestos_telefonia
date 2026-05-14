package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.PacksFutbolEntity;
import com.budgetsgenerator.repository.impl.PacksFutbolDAO;

import jakarta.persistence.EntityManager;

public class PacksFutbolMapper implements EntityMapper<PacksFutbolEntity, PacksFutbolDTO, EntityManager>{
    private static final PacksFutbolMapper instance = new PacksFutbolMapper();
    private static final PacksFutbolDAO packsFutbolDAO = new PacksFutbolDAO(PacksFutbolEntity.class);
    
    private PacksFutbolMapper() {
    }

    public static PacksFutbolMapper getInstance() {
        return instance;
    }

    @Override
    public PacksFutbolDTO toDTO(PacksFutbolEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        PacksFutbolDTO dto = new PacksFutbolDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    @Override
    public PacksFutbolEntity toEntity(PacksFutbolDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        } 
        PacksFutbolEntity entity = new PacksFutbolEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setPrecio(dto.getPrecio());
        return entity;
    }
    
    @Override
    public List<PacksFutbolEntity> toEntityList(List<PacksFutbolDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<PacksFutbolEntity> entitys = new ArrayList<>();
            for(PacksFutbolDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return packsFutbolDAO.findall(em);
    }

    @Override
    public List<PacksFutbolDTO> toDTOList(List<PacksFutbolEntity> entities, EntityManager em) {
        if(entities == null) {
            entities = packsFutbolDAO.findall(em);
        }
        List<PacksFutbolDTO> dtos = new ArrayList<>();
        for(PacksFutbolEntity entity : entities) {
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
}
