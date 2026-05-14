package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.impl.PresupuestosDAO;

import jakarta.persistence.EntityManager;

public class PresupuestosMapper implements EntityMapper<PresupuestosEntity, PresupuestosDTO, EntityManager>{
    private static final PresupuestosMapper instance = new PresupuestosMapper();
    private static final PresupuestosDAO presupuestosDAO = new PresupuestosDAO(PresupuestosEntity.class);
    
    private PresupuestosMapper() {
    }

    public static PresupuestosMapper getInstance(){
        return instance;
    }

    @Override
    public PresupuestosDTO toDTO(PresupuestosEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        PresupuestosDTO dto = new PresupuestosDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTarifa(TarifasMapper.getInstance().toDTO(entity.getTarifa(), em));
        dto.setFibra(FibrasMapper.getInstance().toDTO(entity.getFibra(), em));
        dto.setStreaming(StreamingMapper.getInstance().toDTO(entity.getStreaming(), em));
        dto.setCentralita(CentralitasMapper.getInstance().toDTO(entity.getCentralita(), em));
        dto.setPackFutbol(PacksFutbolMapper.getInstance().toDTO(entity.getPackFutbol(), em));
        dto.setDescuento(DescuentosMapper.getInstance().toDTO(entity.getDescuento(), em));
        dto.setLineasAdicionales(LineasPresupuestoMapper.getInstance().toDTOList(entity.getLineasPresupuesto(), em));
        // if(entity.getLineasPresupuesto() != null) {
        //     dto.setLineasAdicionales(LineasPresupuestoMapper.getInstance().toDTOList(presupuestosDAO.findByIdWithLineasPresupuesto(entity.getId()).getLineasPresupuesto(), em));
        // }
        return dto;
    }

    @Override
    public PresupuestosEntity toEntity(PresupuestosDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        } 
        PresupuestosEntity entity = new PresupuestosEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setTarifa(TarifasMapper.getInstance().toEntity(dto.getTarifa(), em));
        entity.setFibra(FibrasMapper.getInstance().toEntity(dto.getFibra(), em));
        entity.setStreaming(StreamingMapper.getInstance().toEntity(dto.getStreaming(), em));
        entity.setCentralita(CentralitasMapper.getInstance().toEntity(dto.getCentralita(), em));
        entity.setPackFutbol(PacksFutbolMapper.getInstance().toEntity(dto.getPackFutbol(), em));
        entity.setDescuento(DescuentosMapper.getInstance().toEntity(dto.getDescuento(), em));
        entity.setLineasPresupuesto(LineasPresupuestoMapper.getInstance().toEntityList(dto.getLineasAdicionales(), em));
        // if(dto.getLineasAdicionales() != null) {
        //     entity.setLineasPresupuesto(LineasPresupuestoMapper.getInstance().toEntityList(dto.getLineasAdicionales(), em));
        // }
        return entity;
    }
    
    @Override
    public List<PresupuestosEntity> toEntityList(List<PresupuestosDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<PresupuestosEntity> entitys = new ArrayList<>();
            for(PresupuestosDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return presupuestosDAO.findall(em);
    }
    
    @Override
    public List<PresupuestosDTO> toDTOList(List<PresupuestosEntity> entities, EntityManager em) {
        if(entities == null){
            entities = new ArrayList<>();
        }
        List<PresupuestosDTO> dtos = new ArrayList<>();
        for(PresupuestosEntity entity : entities) {
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
}
