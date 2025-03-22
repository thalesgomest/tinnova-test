package com.tinnova.vehicles_rest_api.domain.model.baseModel;

import com.tinnova.vehicles_rest_api.dto.VehicleRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String brand;

  @Column(nullable = false)
  private Integer year;

  @Column(nullable = false)
  private String color;

  @Lob
  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private Boolean sold;

  public Vehicle(VehicleRequestDTO payload) {
    this.name = payload.name();
    this.brand = payload.brand();
    this.year = payload.year();
    this.color = payload.color();
    this.description = payload.description();
    this.sold = payload.sold();
  }
}
