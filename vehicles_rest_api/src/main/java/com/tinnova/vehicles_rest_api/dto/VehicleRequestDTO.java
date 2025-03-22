package com.tinnova.vehicles_rest_api.dto;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleRequestDTO(
                @NotBlank(message = "Nome is required") String nome,
                @NotBlank(message = "Marca is required") VehicleBrands marca,
                @NotNull(message = "Cor is required") String cor,
                Integer ano,
                String descricao,
                @NotNull(message = "Vendido is required") Boolean vendido) {
}
