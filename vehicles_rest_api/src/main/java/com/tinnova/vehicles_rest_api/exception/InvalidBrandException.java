package com.tinnova.vehicles_rest_api.exception;

public class InvalidBrandException extends RuntimeException {

  public InvalidBrandException(String brand) {
    super("Invalid brand: " + brand);
  }
}
