package com.tinnova.vehicles_rest_api.domain.model.baseModel;

import com.tinnova.vehicles_rest_api.domain.enums.VehicleBrands;
import com.tinnova.vehicles_rest_api.dto.VehicleRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends BaseEntity {

  @Column(nullable = false)
  private String nome;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private VehicleBrands marca;

  @Column(nullable = false)
  private Integer ano;

  @Column(nullable = false)
  private String cor;

  @Lob
  @Column(nullable = false)
  private String descricao;

  @Column(nullable = false)
  private Boolean vendido;

  public Vehicle(VehicleRequestDTO payload) {
    this.nome = payload.nome();
    this.marca = payload.marca();
    this.ano = payload.ano();
    this.cor = payload.cor();
    this.descricao = payload.descricao();
    this.vendido = payload.vendido();
  }
}
