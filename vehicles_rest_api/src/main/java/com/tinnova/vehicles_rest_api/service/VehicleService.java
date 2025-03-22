package com.tinnova.vehicles_rest_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;
import com.tinnova.vehicles_rest_api.repository.VehicleRepository;

@Service
public class VehicleService {

  @Autowired
  private VehicleRepository vehicleRepository;

  public List<Vehicle> getAllVehicles() {
    return vehicleRepository.findAll();
  }

  public Vehicle createVehicle(Vehicle newVehicle) {
    return vehicleRepository.save(newVehicle);
  }

  public Vehicle updateVehicle(long id, Vehicle vehicle) {
    Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
    if (!existingVehicle.isPresent()) {
      throw new IllegalArgumentException("Veículo não encontrado");
    }
    return vehicleRepository.save(vehicle);
  }

  public void deleteVehicle(long id) {
    Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
    if (!existingVehicle.isPresent()) {
      throw new IllegalArgumentException("Veículo não encontrado");
    }
    vehicleRepository.delete(existingVehicle.get());
  }

  public long countUnsoldVehicles() {
    return vehicleRepository.findAllVehiclesNaoVendido().size();
  }

  public Optional<Vehicle> getVehicleById(long id) {
    return vehicleRepository.findById(id);
  }

  public List<Vehicle> getVehiclesByDecade() {
    // Lógica para agrupar veículos por década
    return vehicleRepository.findAll(); // Exemplificando. Você deve implementar a lógica de agrupamento
  }

  public List<Vehicle> getVehiclesByBrand() {
    // Lógica para agrupar veículos por marca
    return vehicleRepository.findAll(); // Exemplificando. Você deve implementar a lógica de agrupamento
  }

  public List<Vehicle> getVehiclesFromLastWeek() {
    LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
    return vehicleRepository.findByCreatedBetween(oneWeekAgo, LocalDateTime.now());
  }
}
