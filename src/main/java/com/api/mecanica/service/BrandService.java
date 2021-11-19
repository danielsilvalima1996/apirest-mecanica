package com.api.mecanica.service;

import java.util.List;

import com.api.mecanica.model.Brand;
import com.api.mecanica.repository.BrandRepository;
import com.api.mecanica.service.interfaces.BrandServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements BrandServiceInterface {
	
	@Autowired
	BrandRepository repository;

	@Override
	public Brand findById(Long id) {
		var brand = repository.findById(id);
		if(brand.isPresent())
			return brand.get();
		return null;		
	}

	@Override
	public List<Brand> findAll() {
		return repository.findAll();
	}

	@Override
	public Brand createBrand(Brand brand) {
		Brand dbBrand = repository.save(brand);
		return dbBrand;
	}

	@Override
	public Brand alterBrand(Brand brand) {
		Brand dbBrand = repository.save(brand);
		return dbBrand;
	}

	@Override
	public Long countBrand() {
		return repository.count();
	}

	
	
}
