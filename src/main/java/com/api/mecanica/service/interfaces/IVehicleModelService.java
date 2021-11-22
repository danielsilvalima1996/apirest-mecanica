package com.api.mecanica.service.interfaces;

import java.util.List;

import com.api.mecanica.model.VehicleModel;

public interface IVehicleModelService {

    public VehicleModel findById(Long id);
    public List<VehicleModel> findAll();
    public VehicleModel createVehicleModel(VehicleModel vehicleModel);
    public VehicleModel alterVehicleModel(VehicleModel vehicleModel);
    public Long countVehicleModel();
    
}
