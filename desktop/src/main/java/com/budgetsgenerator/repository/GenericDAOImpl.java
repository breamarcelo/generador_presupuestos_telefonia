package com.budgetsgenerator.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

public abstract class GenericDAOImpl<T, Integer, EM> implements GenericDAO<T, Integer, EntityManager> {
    protected Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    @Override
    public void delete(T entity, EntityManager em) {
        T mergedEntity = em.merge(entity);
        em.remove(mergedEntity);
    }

    @Override
    public T findBy(Integer id, EntityManager em) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findall(EntityManager em) {
        String query = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return em.createQuery(query, entityClass).getResultList();
    }

    @Override
    public T save(T entity, EntityManager em) {
        T managedEntity = em.merge(entity);
        return managedEntity;
    }

    @Override
    public T update(T entity, EntityManager em) {
        T updatedEntity = em.merge(entity);
        return updatedEntity;
    }
}
