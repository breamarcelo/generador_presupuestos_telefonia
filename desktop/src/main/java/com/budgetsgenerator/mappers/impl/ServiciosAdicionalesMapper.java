package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.ServiciosAdicionalesDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.ServiciosAdicionalesEntity;
import com.budgetsgenerator.repository.impl.ServiciosAdicionalesDAO;

import jakarta.persistence.EntityManager;

public class ServiciosAdicionalesMapper implements EntityMapper<ServiciosAdicionalesEntity, ServiciosAdicionalesDTO, EntityManager>{
    private static final ServiciosAdicionalesMapper instance = new ServiciosAdicionalesMapper();
    private static final ServiciosAdicionalesDAO serviciosAdicionalesDAO = new ServiciosAdicionalesDAO(ServiciosAdicionalesEntity.class);
    
    private ServiciosAdicionalesMapper() {
    }

    public static ServiciosAdicionalesMapper getInstance() {
        return instance;
    }

    @Override
    public ServiciosAdicionalesDTO toDTO(ServiciosAdicionalesEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        ServiciosAdicionalesDTO dto = new ServiciosAdicionalesDTO();
        dto.setId(entity.getId());
        dto.setRoaming(entity.getRoaming());
        dto.setInternacional(entity.getInternacional());
        dto.setLegalitas(entity.isLegalitas());
        dto.setCloud(entity.isCloud());
        dto.setCiberProteccion(entity.isCiberProteccion());
        dto.setAtencionPersonalizada(entity.isAtencionPersonalizada());
        dto.setCentralita(entity.getCentralita());
        dto.setNumBeneficios(entity.getNumBeneficios());
        dto.setDescuentoBeneficios(entity.getDescuentoBeneficios());
        return dto;
    }
    
    @Override
    public ServiciosAdicionalesEntity toEntity(ServiciosAdicionalesDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        } 
        ServiciosAdicionalesEntity entity = new ServiciosAdicionalesEntity();
        entity.setId(dto.getId());
        entity.setRoaming(dto.getRoaming());
        entity.setInternacional(dto.getInternacional());
        entity.setLegalitas(dto.isLegalitas());
        entity.setCloud(dto.isCloud());
        entity.setCiberProteccion(dto.isCiberProteccion());
        entity.setAtencionPersonalizada(dto.isAtencionPersonalizada());
        entity.setCentralita(dto.getCentralita());
        entity.setNumBeneficios(dto.getNumBeneficios());
        entity.setDescuentoBeneficios(dto.getDescuentoBeneficios());
        return entity;
    }

    @Override
    public List<ServiciosAdicionalesEntity> toEntityList(List<ServiciosAdicionalesDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<ServiciosAdicionalesEntity> entitys = new ArrayList<>();
            for(ServiciosAdicionalesDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return serviciosAdicionalesDAO.findall(em);
    }

    @Override
    public List<ServiciosAdicionalesDTO> toDTOList(List<ServiciosAdicionalesEntity> entities, EntityManager em) {
        if(entities == null) {
            entities = serviciosAdicionalesDAO.findall(em);
        }
        List<ServiciosAdicionalesDTO> dtos = new ArrayList<>();
        for(ServiciosAdicionalesEntity entity : entities) {
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
}
