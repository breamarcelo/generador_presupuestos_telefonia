package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.ServiciosAdicionalesEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class ServiciosAdicionalesDAO extends GenericDAOImpl<ServiciosAdicionalesEntity, Integer, EntityManager>{

    public ServiciosAdicionalesDAO(Class<ServiciosAdicionalesEntity> entityClass) {
        super(entityClass);
    }

}
