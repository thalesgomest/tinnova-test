package com.tinnova.vehicles_rest_api.domain.enums;

public enum VehicleBrands {
  FORD("FORD"),
  CHEVROLET("CHEVROLET"),
  TOYOTA("TOYOTA"),
  HONDA("HONDA"),
  FIAT("FIAT"),
  NISSAN("NISSAN"),
  BMW("BMW"),
  MERCEDES("MERCEDES"),
  AUDI("AUDI"),
  VOLKSWAGEN("VOLKSWAGEN");

  private final String value;

  VehicleBrands(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
