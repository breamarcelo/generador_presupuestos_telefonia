package com.budgetsgenerator.repository.impl;

import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.repository.GenericDAOImpl;

import jakarta.persistence.EntityManager;

public class LineasPresupuestoDAO extends GenericDAOImpl<LineasPresupuestoEntity, Integer, EntityManager>{

    public LineasPresupuestoDAO(Class<LineasPresupuestoEntity> entityClass) {
        super(entityClass);
    }
}
