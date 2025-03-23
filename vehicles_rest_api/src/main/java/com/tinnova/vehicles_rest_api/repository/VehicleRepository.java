package com.tinnova.vehicles_rest_api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;
import com.tinnova.vehicles_rest_api.domain.model.baseModel.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  List<Vehicle> findAllByMarca(VehicleBrands marca);

  @Query("SELECT v FROM Vehicle v WHERE "
      + "(v.marca = :marca OR :marca IS NULL) AND "
      + "(v.ano = :ano OR :ano IS NULL) AND "
      + "(v.cor = :cor OR :cor IS NULL)")
  List<Vehicle> findAllByQuery(@Param("marca") VehicleBrands marca,
      @Param("ano") Integer ano,
      @Param("cor") String cor);

  @Query("SELECT v FROM Vehicle v WHERE v.vendido = false")
  List<Vehicle> findAllVehiclesUnsold();

  @Query("SELECT marca, COUNT(*) AS qtd FROM Vehicle GROUP BY marca ORDER BY qtd")
  List<Object[]> countByMarca();

  @Query("SELECT v FROM Vehicle v WHERE v.createdAt BETWEEN :start AND :end")
  List<Vehicle> findByLastWeek(LocalDateTime start, LocalDateTime end);

  @Query("SELECT (v.ano / 10) * 10 AS decade, COUNT(*) AS qtd " +
      "FROM Vehicle v " +
      "GROUP BY (v.ano / 10) * 10 " +
      "ORDER BY qtd DESC")
  List<Object[]> findVehiclesByDecade();

}