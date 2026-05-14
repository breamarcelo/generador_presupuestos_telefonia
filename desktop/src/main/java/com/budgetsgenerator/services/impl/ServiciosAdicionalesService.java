package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.ServiciosAdicionalesDTO;
import com.budgetsgenerator.mappers.impl.ServiciosAdicionalesMapper;
import com.budgetsgenerator.models.ServiciosAdicionalesEntity;
import com.budgetsgenerator.repository.impl.ServiciosAdicionalesDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class ServiciosAdicionalesService extends GenericServiceImpl<ServiciosAdicionalesDTO, ServiciosAdicionalesMapper, ServiciosAdicionalesEntity, ServiciosAdicionalesDAO, Integer>{
    private static ServiciosAdicionalesService instance;

    private ServiciosAdicionalesService() {
        super(new ServiciosAdicionalesDAO(ServiciosAdicionalesEntity.class), ServiciosAdicionalesMapper.getInstance());
    }

    public static ServiciosAdicionalesService getInstance() {
        if(instance == null) {
            instance = new ServiciosAdicionalesService();
        }
        return instance;
    }
}
