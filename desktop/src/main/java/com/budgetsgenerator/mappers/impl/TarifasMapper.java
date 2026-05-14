package com.budgetsgenerator.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.mappers.EntityMapper;
import com.budgetsgenerator.models.TarifasEntity;
import com.budgetsgenerator.repository.impl.TarifasDAO;

import jakarta.persistence.EntityManager;

public class TarifasMapper implements EntityMapper<TarifasEntity, TarifasDTO, EntityManager>{
    private static final TarifasMapper instance = new TarifasMapper();
    private static final TarifasDAO tarifasDAO = new TarifasDAO(TarifasEntity.class);
    
    private TarifasMapper() {
    }

    public static TarifasMapper getInstance() {
        return instance;
    }

    @Override
    public TarifasDTO toDTO(TarifasEntity entity, EntityManager em) {
        if(entity == null) {
            return null;
        }
        TarifasDTO dto = new TarifasDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setLineasMoviles(entity.getLineasMoviles());
        dto.setLlamadasMovil(entity.getLlamadasMovil());
        dto.setGbMovil(entity.getGbMovil());
        dto.setFibras(FibrasMapper.getInstance().toDTOList(tarifasDAO.findByIdWithFibras(entity.getId()).getFibras(), em));
        dto.setPrecio(entity.getPrecio());
        dto.setServiciosAdicionales(ServiciosAdicionalesMapper.getInstance().toDTO(entity.getServiciosAdicionales(), em));
        dto.setTv(entity.isTv());
        dto.setStreaming(entity.isStreaming());
        return dto;
    }
    @Override
    public TarifasEntity toEntity(TarifasDTO dto, EntityManager em) {
        if(dto == null) {
            return null;
        }
        TarifasEntity entity = new TarifasEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setTipo(dto.getTipo());
        entity.setLineasMoviles(dto.getLineasMoviles());
        entity.setLlamadasMovil(dto.getLlamadasMovil());
        entity.setGbMovil(dto.getGbMovil());
        //entity.setFibras(tarifasDAO.findByIdWithFibras(dto.getId()).getFibras());
        entity.setPrecio(dto.getPrecio());
        entity.setServiciosAdicionales(ServiciosAdicionalesMapper.getInstance().toEntity(dto.getServiciosAdicionales(), em));
        entity.setTv(dto.isTv());
        entity.setStreaming(dto.isStreaming());
        return entity;
    }
    
    @Override
    public List<TarifasEntity> toEntityList(List<TarifasDTO> dtoList, EntityManager em) {
        if(dtoList != null) {
            List<TarifasEntity> entitys = new ArrayList<>();
            for(TarifasDTO dto : dtoList) {
                entitys.add(toEntity(dto, em));
            }
            return entitys;
        }
        return tarifasDAO.findall(em);
    }
    
    @Override
    public List<TarifasDTO> toDTOList(List<TarifasEntity> entities, EntityManager em) {
        if(entities == null) {
            entities = tarifasDAO.findall(em);
        }
        List<TarifasDTO> dtos = new ArrayList<>();
        for(TarifasEntity entity : entities) {
            dtos.add(toDTO(entity, em));
        }
        return dtos;
    }
}
