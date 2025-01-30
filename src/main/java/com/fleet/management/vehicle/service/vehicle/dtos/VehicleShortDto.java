package com.fleet.management.vehicle.service.vehicle.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleShortDto {

    private String id;
    private String brand;
    private String model;
    private String plateNumber;
    private String status;

}
