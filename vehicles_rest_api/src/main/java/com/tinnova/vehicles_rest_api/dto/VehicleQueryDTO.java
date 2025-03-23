package com.tinnova.vehicles_rest_api.dto;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleQueryDTO {

  private VehicleBrands marca;
  private String cor;
  private Integer ano;

}
