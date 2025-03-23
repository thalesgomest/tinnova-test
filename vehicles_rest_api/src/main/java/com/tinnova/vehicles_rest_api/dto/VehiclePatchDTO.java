package com.tinnova.vehicles_rest_api.dto;

import java.util.Optional;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehiclePatchDTO {
  Optional<String> nome = Optional.empty();
  Optional<VehicleBrands> marca = Optional.empty();
  Optional<String> cor = Optional.empty();
  Optional<Integer> ano = Optional.empty();
  Optional<String> descricao = Optional.empty();
  Optional<Boolean> vendido = Optional.empty();
}
