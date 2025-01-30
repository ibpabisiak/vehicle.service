package com.fleet.management.vehicle.service.vehicle.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    private String id;
    private String brand;
    private String model;
    private Integer year;
    private String vin;
    private String color;
    private Integer mileage;
    private Integer engineSize;
    private String fuelType;
    private String transmission;
    private String plateNumber;
    private String status;

}
