package com.tinnova.vehicles_rest_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleRequestDTO(
    @NotBlank(message = "Vehicle is required") String name,
    @NotBlank(message = "Brand is required") String brand,
    @NotNull(message = "Color is required") String color,
    @NotNull(message = "Year is required") Integer year,
    String description,
    @NotNull(message = "Sold is required") Boolean sold) {
}
