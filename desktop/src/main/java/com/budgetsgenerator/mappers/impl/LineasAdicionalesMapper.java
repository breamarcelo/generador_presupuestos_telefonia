package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.LineasAdicionalesEntity;
import com.budgetsgenerator.repository.impl.LineasAdicionalesDAO;

import jakarta.persistence.EntityManager;

public class LineasAdicionalesMapper implements EntityMapper<LineasAdicionalesEntity, LineasAdicionalesDTO, EntityManager>{
    public static final LineasAdicionalesMapper instance = new LineasAdicionalesMapper();
    public static final LineasAdicionalesDAO lineasAdicionalesDAO = new LineasAdicionalesDAO(LineasAdicionalesEntity.class);
    
    private LineasAdicionalesMapper() {
    }

    public static LineasAdicionalesMapper getInstance() {
        return instance;
    }

    @Override
    public LineasAdicionalesDTO toDTO(LineasAdicionalesEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        LineasAdicionalesDTO dto = new LineasAdicionalesDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setNumLineas(entity.getNumLineas());
        dto.setLlamadas(entity.getLlamadas());
        dto.setGb(entity.getGb());
        dto.setFibra(entity.getFibra());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    @Override
    public LineasAdicionalesEntity toEntity(LineasAdicionalesDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        } 
        LineasAdicionalesEntity entity = new LineasAdicionalesEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setTipo(dto.getTipo());
        entity.setNumLineas(dto.getNumLineas());
        entity.setLlamadas(dto.getLlamadas());
        entity.setGb(dto.getGb());
        entity.setFibra(dto.getFibra());
        entity.setPrecio(dto.getPrecio());
        return entity;
    }

    @Override
    public List<LineasAdicionalesEntity> toEntityList(List<LineasAdicionalesDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<LineasAdicionalesEntity> entitys = new ArrayList<>();
            for(LineasAdicionalesDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return lineasAdicionalesDAO.findall(em);
    }

    @Override
    public List<LineasAdicionalesDTO> toDTOList(List<LineasAdicionalesEntity> entities, EntityManager em) {
        if(entities == null){
            entities = lineasAdicionalesDAO.findall(em);
        }
        List<LineasAdicionalesDTO> dtos = new ArrayList<>();
        for(LineasAdicionalesEntity entity : entities) {
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
}
