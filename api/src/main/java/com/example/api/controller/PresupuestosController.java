package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dto.ResultDTO;
import com.example.api.model.LineasPresupuestoEntity;
import com.example.api.model.PresupuestosEntity;
import com.example.api.repository.LineasPresupuestoRepository;
import com.example.api.repository.PresupuestosRepository;
import com.example.api.service.PresupuestosService;

@RestController
@CrossOrigin(origins="*")   
@RequestMapping("/api/presupuestos")
public class PresupuestosController {
    @Autowired
    private PresupuestosRepository repository;

    @Autowired
    private LineasPresupuestoRepository lineasRepository;
    
    @Autowired
    private PresupuestosService presupuestosService;

    @GetMapping()
    public List<ResultDTO> getAll() {
        List<ResultDTO> dtos = new ArrayList<>();
        List<PresupuestosEntity> presupuestos = repository.findAll();
        for (PresupuestosEntity presupuestoEntity : presupuestos) {
            List<LineasPresupuestoEntity> lineasEntities = lineasRepository.findAllByPresupuestoId(presupuestoEntity.getId());
            dtos.add(presupuestosService.getInstance().toDto(presupuestoEntity, lineasEntities));
        }
        
        return dtos;
    }

    @GetMapping("/{id}")
    public ResultDTO getById(@PathVariable int id) {
        PresupuestosEntity entity = repository.findById(id).get();
        List<LineasPresupuestoEntity> lineas = lineasRepository.findAllByPresupuestoId(entity.getId());
        ResultDTO dto = presupuestosService.getInstance().toDto(entity, lineas);
        return dto;
    }
}
