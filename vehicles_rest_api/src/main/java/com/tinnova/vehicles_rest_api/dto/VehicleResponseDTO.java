package com.tinnova.vehicles_rest_api.dto;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;
import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;

public record VehicleResponseDTO(
    Long id,
    String nome,
    VehicleBrands marca,
    String color,
    Integer ano,
    String descricao,
    Boolean vendido) {

  public VehicleResponseDTO(Vehicle vehicle) {
    this(vehicle.getId(), vehicle.getNome(), vehicle.getMarca(), vehicle.getCor(), vehicle.getAno(),
        vehicle.getDescricao(), vehicle.getVendido());
  }
}
