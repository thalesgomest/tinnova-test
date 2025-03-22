package com.tinnova.vehicles_rest_api.service;

import org.springframework.stereotype.Service;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;
import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;
import com.tinnova.vehicles_rest_api.exception.InvalidBrandException;

@Service
public class VehicleService {

  public Vehicle creatVehicle(Vehicle newVehicle) {
    return newVehicle;
  }

  public void validateBrand(String brand) throws InvalidBrandException {
    try {
      VehicleBrands.valueOf(brand.toUpperCase());
    } catch (InvalidBrandException e) {
      throw new InvalidBrandException(brand);
    }
  }

}
