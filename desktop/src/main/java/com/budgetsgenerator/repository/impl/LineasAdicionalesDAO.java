package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.LineasAdicionalesEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class LineasAdicionalesDAO extends GenericDAOImpl<LineasAdicionalesEntity, Integer, EntityManager>{

    public LineasAdicionalesDAO(Class<LineasAdicionalesEntity> entityClass) {
        super(entityClass);
    }

}
