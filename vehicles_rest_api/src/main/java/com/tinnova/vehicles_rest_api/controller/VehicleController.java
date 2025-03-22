package com.tinnova.vehicles_rest_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;
import com.tinnova.vehicles_rest_api.dto.VehicleRequestDTO;
import com.tinnova.vehicles_rest_api.dto.VehicleResponseDTO;
import com.tinnova.vehicles_rest_api.service.VehicleService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehicleController {

  @Autowired
  private VehicleService vehicleService;

  @GetMapping
  public ResponseEntity<List<Vehicle>> getAllVehicles() {

    List<Vehicle> vehicles = vehicleService.getAllVehicles();
    return new ResponseEntity<>(vehicles, HttpStatus.OK);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<?> createVehicle(@Valid @RequestBody VehicleRequestDTO vehicleRequestBody) {
    Vehicle vehicle = new Vehicle(vehicleRequestBody);
    Vehicle savedVehicle = this.vehicleService.createVehicle(vehicle);

    VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO(savedVehicle);
    return new ResponseEntity<>(vehicleResponseDTO, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getVehicleById(@PathVariable int id) {
    Optional<Vehicle> existVehicle = this.vehicleService.getVehicleById(id);

    if (existVehicle.isPresent()) {
      VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO(existVehicle.get());
      return new ResponseEntity<>(vehicleResponseDTO, HttpStatus.OK);
    }

    return new ResponseEntity<>("Veículo não encontrado", HttpStatus.NOT_FOUND);

  }
}
