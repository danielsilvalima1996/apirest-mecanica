package com.api.mecanica.repository;

import com.api.mecanica.model.Brand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    
}
