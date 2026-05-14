package com.budgetsgenerator.repository.impl;

import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.PresupuestosDTO;
import com.budgetsgenerator.mappers.impl.CentralitasMapper;
import com.budgetsgenerator.mappers.impl.DescuentosMapper;
import com.budgetsgenerator.mappers.impl.FibrasMapper;
import com.budgetsgenerator.mappers.impl.PacksFutbolMapper;
import com.budgetsgenerator.mappers.impl.StreamingMapper;
import com.budgetsgenerator.mappers.impl.TarifasMapper;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.models.PresupuestosEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class PresupuestosDAO extends GenericDAOImpl<PresupuestosEntity, Integer, EntityManager>{

    public PresupuestosDAO(Class<PresupuestosEntity> entityClass) {
        super(entityClass);
    }

    public PresupuestosEntity findByIdWithLineasPresupuesto(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT t FROM PresupuestosEntity t LEFT JOIN FETCH t.lineasPresupuesto WHERE t.id = :id", 
                PresupuestosEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        } finally {
            em.close();
        }
    }

    public PresupuestosEntity savePresupuesto(PresupuestosEntity presuspuestoEntity, List<LineasPresupuestoEntity> lineasPresupuestoEntitys, EntityManager em) {
        PresupuestosEntity savedPresupuesto = em.merge(presuspuestoEntity);
        em.flush();
        savedPresupuesto.getLineasPresupuesto().clear();
        if(lineasPresupuestoEntitys != null) {
            for(LineasPresupuestoEntity lineaEntity : lineasPresupuestoEntitys){
                lineaEntity.setPresupuesto(savedPresupuesto);
                savedPresupuesto.getLineasPresupuesto().add(lineaEntity);
            }
            savedPresupuesto = em.merge(savedPresupuesto);
        }
        return savedPresupuesto;
    }

    public PresupuestosEntity updatePresupuesto(PresupuestosDTO dto, PresupuestosEntity presuspuestoEntity, List<LineasPresupuestoEntity> lineasPresupuestoEntitys, EntityManager em) {
        if(dto.getTarifa() != null) {
            presuspuestoEntity.setTarifa(TarifasMapper.getInstance().toEntity(dto.getTarifa(), em));
        }
        if(dto.getFibra() != null){
            presuspuestoEntity.setFibra(FibrasMapper.getInstance().toEntity(dto.getFibra(), em));
        }
        if(dto.getStreaming() != null) {
            presuspuestoEntity.setStreaming(StreamingMapper.getInstance().toEntity(dto.getStreaming(), em));
        }
        if(dto.getCentralita() != null) {
            presuspuestoEntity.setCentralita(CentralitasMapper.getInstance().toEntity(dto.getCentralita(), em));
        }
        if(dto.getPackFutbol() != null) {
            presuspuestoEntity.setPackFutbol(PacksFutbolMapper.getInstance().toEntity(dto.getPackFutbol(), em));
        }
        if(dto.getDescuento() != null) {
            presuspuestoEntity.setDescuento(DescuentosMapper.getInstance().toEntity(dto.getDescuento(), em));
        }
        presuspuestoEntity.getLineasPresupuesto().clear();
        em.flush();
        if(lineasPresupuestoEntitys != null) {
            for(LineasPresupuestoEntity lineaEntity : lineasPresupuestoEntitys) {
                lineaEntity.setPresupuesto(presuspuestoEntity);
                presuspuestoEntity.getLineasPresupuesto().add(lineaEntity);
            }
            presuspuestoEntity = em.merge(presuspuestoEntity);
        }
        return presuspuestoEntity;
    }
}
