package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.PacksFutbolEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class PacksFutbolDAO extends GenericDAOImpl<PacksFutbolEntity, Integer, EntityManager>{

    public PacksFutbolDAO(Class<PacksFutbolEntity> entityClass) {
        super(entityClass);
    }

}
