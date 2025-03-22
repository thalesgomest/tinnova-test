package com.tinnova.vehicles_rest_api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;
import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  List<Vehicle> findAllByMarca(VehicleBrands marca);

  @Query("SELECT v FROM Vehicle v WHERE v.vendido = true")
  List<Vehicle> findAllVehiclesVendido();

  @Query("SELECT v FROM Vehicle v WHERE v.vendido = false")
  List<Vehicle> findAllVehiclesNaoVendido();

  @Query("SELECT v FROM Vehicle v WHERE v.createdAt BETWEEN :start AND :end")
  List<Vehicle> findByCreatedBetween(LocalDateTime start, LocalDateTime end);

  @Query("SELECT v FROM Vehicle v WHERE v.ano BETWEEN :startYear AND :endYear")
  List<Vehicle> findByYearBetween(Integer startYear, Integer endYear);

}