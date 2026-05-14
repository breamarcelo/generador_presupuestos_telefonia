package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.LineasPresupuestoEntity;

public interface LineasPresupuestoRepository extends JpaRepository<LineasPresupuestoEntity, Integer>{
    List<LineasPresupuestoEntity> findAllByPresupuestoId(int id);
}   
