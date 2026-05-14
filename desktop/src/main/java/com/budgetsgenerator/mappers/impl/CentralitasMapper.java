package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.CentralitasEntity;
import com.budgetsgenerator.repository.impl.CentralitasDAO;

import jakarta.persistence.EntityManager;

public class CentralitasMapper implements EntityMapper<CentralitasEntity, CentralitasDTO, EntityManager>{
    private static final CentralitasMapper instance = new CentralitasMapper();
    private static final CentralitasDAO centralitasDAO = new CentralitasDAO(CentralitasEntity.class);

    private CentralitasMapper(){
    }

    public static CentralitasMapper getInstance(){
        return instance;
    }
    
    @Override
    public CentralitasDTO toDTO(CentralitasEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        CentralitasDTO dto = new CentralitasDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    @Override
    public CentralitasEntity toEntity(CentralitasDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        } 
        CentralitasEntity entity = new CentralitasEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setPrecio(dto.getPrecio());
        return entity;
    }

    @Override
    public List<CentralitasEntity> toEntityList(List<CentralitasDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<CentralitasEntity> entitys = new ArrayList<>();
            for(CentralitasDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return centralitasDAO.findall(em);
    }

    @Override
    public List<CentralitasDTO> toDTOList(List<CentralitasEntity> entities, EntityManager em) {
        if(entities == null) {
            entities = centralitasDAO.findall(em);
        }
        List<CentralitasDTO> dtos = new ArrayList<>();
        for(CentralitasEntity entity : entities) {
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
}
