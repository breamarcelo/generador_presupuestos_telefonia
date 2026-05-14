package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.CentralitasEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class CentralitasDAO extends GenericDAOImpl<CentralitasEntity, Integer, EntityManager>{

    public CentralitasDAO(Class<CentralitasEntity> entityClass) {
        super(entityClass);
    }

}
