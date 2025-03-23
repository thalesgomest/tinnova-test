package com.tinnova.vehicles_rest_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;
import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;
import com.tinnova.vehicles_rest_api.dto.VehiclePatchDTO;
import com.tinnova.vehicles_rest_api.dto.VehicleQueryDTO;
import com.tinnova.vehicles_rest_api.dto.VehicleRequestDTO;
import com.tinnova.vehicles_rest_api.repository.VehicleRepository;

@Service
public class VehicleService {

  @Autowired
  private VehicleRepository vehicleRepository;

  public List<Vehicle> getAllVehicles(VehicleQueryDTO query) {
    return vehicleRepository.findAllByQuery(query.getMarca(), query.getAno(), query.getCor());
  }

  public Vehicle createVehicle(Vehicle newVehicle) {
    return vehicleRepository.save(newVehicle);
  }

  public Vehicle updateVehicle(long id, VehicleRequestDTO vehicle) {
    Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
    if (!existingVehicle.isPresent()) {
      throw new IllegalArgumentException("Veículo não encontrado");
    }
    return existingVehicle.map(entity -> {
      entity.setNome(vehicle.nome());
      entity.setMarca(vehicle.marca());
      entity.setAno(vehicle.ano());
      entity.setCor(vehicle.cor());
      entity.setDescricao(vehicle.descricao());
      entity.setVendido(vehicle.vendido());
      return vehicleRepository.save(entity);
    }).orElse(null);
  }

  public Vehicle updateVehicle(long id, VehiclePatchDTO vehicle) {
    Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
    if (!existingVehicle.isPresent()) {
      throw new IllegalArgumentException("Veículo não encontrado");
    }
    return existingVehicle.map(entity -> {
      vehicle.getNome().ifPresent(n -> entity.setNome(n));
      vehicle.getMarca().ifPresent(n -> entity.setMarca(n));
      vehicle.getAno().ifPresent(n -> entity.setAno(n));
      vehicle.getCor().ifPresent(n -> entity.setCor(n));
      vehicle.getDescricao().ifPresent(n -> entity.setDescricao(n));
      vehicle.getVendido().ifPresent(n -> entity.setVendido(n));
      return vehicleRepository.save(entity);
    }).orElse(null);
  }

  public void deleteVehicle(long id) {
    Optional<Vehicle> existingVehicle = vehicleRepository.findById(id);
    if (!existingVehicle.isPresent()) {
      throw new IllegalArgumentException("Veículo não encontrado");
    }
    vehicleRepository.delete(existingVehicle.get());
  }

  public long countUnsoldVehicles() {
    return vehicleRepository.findAllVehiclesUnsold().size();
  }

  public Optional<Vehicle> getVehicleById(long id) {
    return vehicleRepository.findById(id);
  }

  public Map<Integer, Long> getVehiclesByDecade() {
    List<Object[]> result = vehicleRepository.findVehiclesByDecade();
    Map<Integer, Long> count = result.stream()
        .collect(java.util.stream.Collectors.toMap(o -> (Integer) o[0], o -> (Long) o[1]));
    return count;
  }

  public List<Vehicle> getVehiclesFromLastWeek() {
    LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1);
    return vehicleRepository.findByLastWeek(oneWeekAgo, LocalDateTime.now());
  }

  public Map<VehicleBrands, Long> countByMarca() {
    List<Object[]> result = vehicleRepository.countByMarca();
    Map<VehicleBrands, Long> count = result.stream()
        .collect(java.util.stream.Collectors.toMap(o -> (VehicleBrands) o[0], o -> (Long) o[1]));
    return count;
  }
}
