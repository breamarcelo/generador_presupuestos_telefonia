package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.StreamingEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class StreamingDAO extends GenericDAOImpl<StreamingEntity, Integer, EntityManager>{

    public StreamingDAO(Class<StreamingEntity> entityClass) {
        super(entityClass);
    }
}
