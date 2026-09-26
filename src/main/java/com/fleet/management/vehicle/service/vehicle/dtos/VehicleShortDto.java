package com.fleet.management.vehicle.service.vehicle.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class VehicleShortDto {

    private UUID id;
    private String manufacturer;
    private String model;
    private String plateNumber;
    private String status;

}
