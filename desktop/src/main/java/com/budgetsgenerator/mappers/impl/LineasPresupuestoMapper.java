package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.repository.impl.LineasPresupuestoDAO;

import jakarta.persistence.EntityManager;

public class LineasPresupuestoMapper implements EntityMapper<LineasPresupuestoEntity, LineasPresupuestoDTO, EntityManager> {
    private static final LineasPresupuestoMapper instance = new LineasPresupuestoMapper();
    private static final LineasPresupuestoDAO lineasPresupuestoDAO = new LineasPresupuestoDAO(LineasPresupuestoEntity.class);

    private LineasPresupuestoMapper() {
    }

    public static LineasPresupuestoMapper getInstance(){
        return instance;
    }

    @Override
    public LineasPresupuestoDTO toDTO(LineasPresupuestoEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        LineasPresupuestoDTO dto = new LineasPresupuestoDTO();
        dto.setId(entity.getId());
        dto.setCantidad(entity.getCantidad());
        dto.setLineasAdicional(LineasAdicionalesMapper.getInstance().toDTO(entity.getLineaAdicional(), em));
        return dto;
    }

    @Override
    public LineasPresupuestoEntity toEntity(LineasPresupuestoDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        } 
        LineasPresupuestoEntity entity = new LineasPresupuestoEntity();
        entity.setId(null);
        entity.setCantidad(dto.getCantidad());
        entity.setPresupuesto(PresupuestosMapper.getInstance().toEntity(dto.getPresupuesto(), em));
        entity.setLineaAdicional(LineasAdicionalesMapper.getInstance().toEntity(dto.getLineasAdicional(), em));
        return entity;
    }
    
    @Override
    public List<LineasPresupuestoEntity> toEntityList(List<LineasPresupuestoDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<LineasPresupuestoEntity> entitys = new ArrayList<>();
            for(LineasPresupuestoDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return lineasPresupuestoDAO.findall(em);
    }
    
    @Override
    public List<LineasPresupuestoDTO> toDTOList(List<LineasPresupuestoEntity> entities, EntityManager em) {
        if(entities == null) {
            entities = new ArrayList<>();
        }
        List<LineasPresupuestoDTO> dtos = new ArrayList<>();
        for(LineasPresupuestoEntity entity : entities) {
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
}
