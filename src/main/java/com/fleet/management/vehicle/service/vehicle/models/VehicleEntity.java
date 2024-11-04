package com.fleet.management.vehicle.service.vehicle.models;


import jakarta.persistence.*;
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
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String make;
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
