package com.tinnova.vehicles_rest_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;
import com.tinnova.vehicles_rest_api.dto.VehicleRequestDTO;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehicleController {

  @PostMapping
  @Transactional
  public ResponseEntity<Vehicle> createVehicle(@Valid VehicleRequestDTO vehicleRequestBody) {
    Vehicle vehicle = new Vehicle(vehicleRequestBody);
    return ResponseEntity.ok(vehicle);
  }
}
