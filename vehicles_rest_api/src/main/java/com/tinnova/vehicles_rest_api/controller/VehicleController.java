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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin
@Tag(name = "Vehicles management", description = "APIs for managing vehicles for Tinnova test")
public class VehicleController {

  @Autowired
  private VehicleService vehicleService;

  @Operation(summary = "Get all vehicles", description = "Retorna todos os veículos cadastrados na base de dados")
  @GetMapping
  public ResponseEntity<List<Vehicle>> getAllVehicles(VehicleQueryDTO query) {
    List<Vehicle> vehicles = vehicleService.getAllVehicles(query);
    return new ResponseEntity<>(vehicles, HttpStatus.OK);
  }

  @Operation(summary = "Create a new vehicle", description = "Cria um novo veículo na base de dados")
  @PostMapping
  @Transactional
  public ResponseEntity<?> createVehicle(@Valid @RequestBody VehicleRequestDTO body) {
    Vehicle vehicle = new Vehicle(body);
    Vehicle savedVehicle = this.vehicleService.createVehicle(vehicle);

    VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO(savedVehicle);
    return new ResponseEntity<>(vehicleResponseDTO, HttpStatus.CREATED);
  }

  @Operation(summary = "Get vehicle by id", description = "Retorna um veículo cadastrado na base de dados com base no id")
  @GetMapping("/{id}")
  public ResponseEntity<?> getVehicleById(@PathVariable int id) {
    Optional<Vehicle> existVehicle = this.vehicleService.getVehicleById(id);

    if (existVehicle.isPresent()) {
      VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO(existVehicle.get());
      return new ResponseEntity<>(vehicleResponseDTO, HttpStatus.OK);
    }

    return new ResponseEntity<>("Veículo não encontrado", HttpStatus.NOT_FOUND);
  }

  @Operation(summary = "Delete vehicle by id", description = "Deleta um veículo cadastrado na base de dados com base no id")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteVehicle(@PathVariable int id) {
    this.vehicleService.deleteVehicle(id);
    return new ResponseEntity<>("Veiculo deletado com sucesso", HttpStatus.OK);
  }

  @Operation(summary = "Update vehicle by id", description = "Atualiza os dados de um veículo cadastrado na base de dados com base no id")
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

  @Operation(summary = "Update partial data of vehicle by id", description = "Atualiza os dados, de forma total ou parcial de um veículo cadastrado na base de dados com base no id")
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

  @Operation(summary = "Count unsold vehicles", description = "Retorna a quantidade de veículos nao vendidos")
  @GetMapping("/unsold")
  public ResponseEntity<?> countUnsoldVehicles() {
    long count = this.vehicleService.countUnsoldVehicles();
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @Operation(summary = "Count vehicles by brand", description = "Retorna a quantidade de veículos por marca")
  @GetMapping("/brand")
  public ResponseEntity<?> countByMarca() {
    Map<VehicleBrands, Long> count = this.vehicleService.countByMarca();
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @Operation(summary = "Count vehicles by decade", description = "Retorna a quantidade de veículos por decada")
  @GetMapping("/decade")
  public ResponseEntity<?> getVehiclesByDecade() {
    Map<Integer, Long> vehicles = this.vehicleService.getVehiclesByDecade();
    return new ResponseEntity<>(vehicles, HttpStatus.OK);
  }

  @Operation(summary = "Get vehicles from last week", description = "Retorna os veículos criados na ultima semana")
  @GetMapping("/lastweek")
  public ResponseEntity<?> getVehiclesFromLastWeek() {
    List<Vehicle> vehicles = this.vehicleService.getVehiclesFromLastWeek();
    return new ResponseEntity<>(vehicles, HttpStatus.OK);
  }

}
