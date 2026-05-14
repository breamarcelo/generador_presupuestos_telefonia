package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.DescuentosEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class DescuentosDAO extends GenericDAOImpl<DescuentosEntity, Integer, EntityManager>{

    public DescuentosDAO(Class<DescuentosEntity> entityClass) {
        super(entityClass);
    }

}
