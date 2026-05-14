package com.budgetsgenerator.services.impl;

import com.budgetsgenerator.dto.FibrasDTO;
import com.budgetsgenerator.mappers.impl.FibrasMapper;
import com.budgetsgenerator.models.FibrasEntity;
import com.budgetsgenerator.repository.impl.FibrasDAO;
import com.budgetsgenerator.services.GenericServiceImpl;

public class FibrasService extends GenericServiceImpl<FibrasDTO, FibrasMapper, FibrasEntity, FibrasDAO, Integer>{
    private static FibrasService instance;

    private FibrasService() {
        super(new FibrasDAO(FibrasEntity.class), FibrasMapper.getInstance());
    }
    
    public static FibrasService getInstance() {
        if(instance == null) {
            instance = new FibrasService();
        }
        return instance;
    }
}
