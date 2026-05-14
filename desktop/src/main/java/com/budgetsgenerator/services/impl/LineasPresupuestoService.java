package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.LineasPresupuestoDTO;
import com.budgetsgenerator.mappers.impl.LineasPresupuestoMapper;
import com.budgetsgenerator.models.LineasPresupuestoEntity;
import com.budgetsgenerator.repository.impl.LineasAdicionalesDAO;
import com.budgetsgenerator.repository.impl.LineasPresupuestoDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class LineasPresupuestoService extends GenericServiceImpl<LineasPresupuestoDTO, LineasPresupuestoMapper, LineasPresupuestoEntity, LineasAdicionalesDAO, Integer>{
    private static LineasPresupuestoService instance;

    private LineasPresupuestoService() {
        super(new LineasPresupuestoDAO(LineasPresupuestoEntity.class), LineasPresupuestoMapper.getInstance());
    }

    public static LineasPresupuestoService getInstance() {
        if(instance == null) {
            instance = new LineasPresupuestoService();
        }
        return instance;
    }
}
