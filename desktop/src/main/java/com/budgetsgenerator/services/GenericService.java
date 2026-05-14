package com.budgetsgenerator.services;

import java.util.List;

public interface GenericService<DTO, M, E, DAO, Integer> {
    List<DTO> getAll();
    DTO findById(Integer id);
    DTO save(DTO dto);
    DTO update(DTO dto);
    void delete(DTO dto);
}
