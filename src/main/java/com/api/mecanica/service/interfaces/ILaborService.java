package com.api.mecanica.service.interfaces;

import java.util.List;

import com.api.mecanica.model.Labor;

public interface ILaborService {

    public Labor findById(Long id);
    public List<Labor> findAll();
    public Labor createLabor(Labor labor);
    public Labor alterLabor(Labor labor);
    public Long countLabor();
    
}
