package com.budgetsgenerator.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.config.JPAUtil;
import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.dto.ServiciosAdicionalesDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.mappers.impl.FibrasMapper;
import com.budgetsgenerator.mappers.impl.ServiciosAdicionalesMapper;
import com.budgetsgenerator.mappers.impl.TarifasMapper;
import com.budgetsgenerator.models.FibrasEntity;
import com.budgetsgenerator.models.ServiciosAdicionalesEntity;
import com.budgetsgenerator.models.TarifasEntity;
import com.budgetsgenerator.repository.impl.TarifasDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

import jakarta.persistence.EntityManager;

public class TarifasService extends GenericServiceImpl<TarifasDTO, TarifasMapper, TarifasEntity, TarifasDAO, Integer>{
    private static TarifasService instance;

    private TarifasService() {
        super(new TarifasDAO(TarifasEntity.class), TarifasMapper.getInstance());
    }

    public static TarifasService getInstance() {
        if(instance == null) {
            instance = new TarifasService();
        }
        return instance;
    }

    public static void saveTarifa(ServiciosAdicionalesDTO serviciosAdicionalesDTO, TarifasDTO tarifasDTO, List<FibrasDTO> fibraList, EntityManager em) {
        em = JPAUtil.getEntityManager();
        TarifasDAO tarifasDAO = new TarifasDAO(TarifasEntity.class);

        try {
            em.getTransaction().begin();
            ServiciosAdicionalesEntity serviciosAdicionalesEntity = ServiciosAdicionalesMapper.getInstance().toEntity(serviciosAdicionalesDTO, em);
            TarifasEntity tarifasEntity = TarifasMapper.getInstance().toEntity(tarifasDTO, em);
            tarifasEntity.setFibras(new ArrayList<>());
            List<FibrasEntity> fibrasEntitys = FibrasMapper.getInstance().toEntityList(fibraList, em);
            tarifasDAO.saveTarifa(serviciosAdicionalesEntity, tarifasEntity, fibrasEntitys, em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            } 
            throw e;  
        } finally {
            em.close();
        }
    }

    public static void updateTarifa(TarifasDTO tarifa, List<FibrasDTO> fibrasDTOs) {
        EntityManager em = JPAUtil.getEntityManager();
        TarifasDAO tarifasDAO = new TarifasDAO(TarifasEntity.class);
        try {
            em.getTransaction().begin();
            TarifasEntity tarifasEntity = TarifasMapper.getInstance().toEntity(tarifa, em);
            List<FibrasEntity> fibrasEntitys = FibrasMapper.getInstance().toEntityList(fibrasDTOs, em);
            tarifasDAO.updateTarifa(tarifasEntity, fibrasEntitys, em);
            em.getTransaction().commit();
        } catch(Exception e) {
          if(em.getTransaction().isActive()) {
            em.getTransaction().rollback();
          } 
          throw e;
        } finally {
            em.close();
        }
    }
}
