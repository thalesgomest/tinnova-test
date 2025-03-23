package com.tinnova.vehicles_rest_api.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;
import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;
import com.tinnova.vehicles_rest_api.dto.VehiclePatchDTO;
import com.tinnova.vehicles_rest_api.dto.VehicleQueryDTO;
import com.tinnova.vehicles_rest_api.dto.VehicleRequestDTO;
import com.tinnova.vehicles_rest_api.dto.VehicleResponseDTO;
import com.tinnova.vehicles_rest_api.service.VehicleService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin
public class VehicleController {

  @Autowired
  private VehicleService vehicleService;

  @GetMapping
  public ResponseEntity<List<Vehicle>> getAllVehicles(VehicleQueryDTO query) {
    List<Vehicle> vehicles = vehicleService.getAllVehicles(query);
    return new ResponseEntity<>(vehicles, HttpStatus.OK);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<?> createVehicle(@Valid @RequestBody VehicleRequestDTO body) {
    Vehicle vehicle = new Vehicle(body);
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

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteVehicle(@PathVariable int id) {
    this.vehicleService.deleteVehicle(id);
    return new ResponseEntity<>("Veiculo deletado com sucesso", HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateVehicle(@PathVariable int id,
      @Valid @RequestBody VehicleRequestDTO body) {
    Vehicle updatedVehicle = this.vehicleService.updateVehicle(id, body);
    if (updatedVehicle == null) {
      return new ResponseEntity<>("Veiculo nao encontrado", HttpStatus.NOT_FOUND);
    }
    VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO(updatedVehicle);
    return new ResponseEntity<>(vehicleResponseDTO, HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<?> updateVehicle(@PathVariable int id,
      @Valid @RequestBody VehiclePatchDTO body) {
    Vehicle updatedVehicle = this.vehicleService.updateVehicle(id, body);
    if (updatedVehicle == null) {
      return new ResponseEntity<>("Veiculo nao encontrado", HttpStatus.NOT_FOUND);
    }
    VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO(updatedVehicle);
    return new ResponseEntity<>(vehicleResponseDTO, HttpStatus.OK);
  }

  @GetMapping("/unsold")
  public ResponseEntity<?> countUnsoldVehicles() {
    long count = this.vehicleService.countUnsoldVehicles();
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @GetMapping("/brand")
  public ResponseEntity<?> countByMarca() {
    Map<VehicleBrands, Long> count = this.vehicleService.countByMarca();
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @GetMapping("/decade")
  public ResponseEntity<?> getVehiclesByDecade() {
    Map<Integer, Long> vehicles = this.vehicleService.getVehiclesByDecade();
    return new ResponseEntity<>(vehicles, HttpStatus.OK);
  }

}
