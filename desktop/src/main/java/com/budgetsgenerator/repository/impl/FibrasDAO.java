package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.FibrasEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class FibrasDAO extends GenericDAOImpl<FibrasEntity, Integer, EntityManager>{

    public FibrasDAO(Class<FibrasEntity> entityClass) {
        super(entityClass);
    
    }

}
