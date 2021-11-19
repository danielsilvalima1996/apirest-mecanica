package com.api.mecanica.service.interfaces;

import java.util.List;

import com.api.mecanica.model.Brand;

public interface BrandServiceInterface {

    public Brand findById(Long id);
    public List<Brand> findAll();
    public Brand createBrand(Brand brand);
    public Brand alterBrand(Brand brand);
    public Long countBrand();
    
}
