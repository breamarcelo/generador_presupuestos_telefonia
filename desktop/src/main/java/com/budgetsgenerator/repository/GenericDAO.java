package com.budgetsgenerator.repository;

import java.util.List;

public interface GenericDAO<T, Integer, EM> {
    T save(T entity, EM em);
    T findBy(Integer id, EM em);
    List<T> findall(EM em);
    T update(T entity, EM em);
    void delete(T entity, EM em);
}
