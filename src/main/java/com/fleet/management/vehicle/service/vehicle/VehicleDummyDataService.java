package com.fleet.management.vehicle.service.vehicle;

import com.fleet.management.vehicle.service.vehicle.models.VehicleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for generating dummy data
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleDummyDataService implements InitializingBean {

    private final VehicleRepository vehicleRepository;

    @Override
    public void afterPropertiesSet() {
        var entities = vehicleRepository.findAll();
        if (entities.isEmpty()) {
            log.info("Creating dummy data.");
            List<VehicleEntity> vehicles = new ArrayList<>();
            vehicles.add(new VehicleEntity(null, "Toyota", "Camry", 2018, "1HGCM82633A123456", "Red", 50000, 2000, "Petrol", "Automatic", "ABC123", "Available"));
            vehicles.add(new VehicleEntity(null, "Ford", "Focus", 2015, "1HGCM82633A654321", "Blue", 75000, 1600, "Diesel", "Manual", "XYZ789", "Available"));
            vehicles.add(new VehicleEntity(null, "Honda", "Civic", 2020, "1HGCM82633A111111", "Black", 30000, 1800, "Hybrid", "Automatic", "LMN456", "Rented"));
            vehicles.add(new VehicleEntity(null, "Chevrolet", "Malibu", 2017, "1HGCM82633A222222", "White", 82000, 2500, "Petrol", "Automatic", "PLQ789", "Maintenance"));
            vehicles.add(new VehicleEntity(null, "Nissan", "Altima", 2019, "1HGCM82633A333333", "Gray", 45000, 2400, "Diesel", "Manual", "OPQ123", "Available"));
            vehicles.add(new VehicleEntity(null, "BMW", "3 Series", 2021, "1HGCM82633A444444", "Silver", 28000, 2000, "Electric", "Automatic", "RST456", "Rented"));
            vehicles.add(new VehicleEntity(null, "Audi", "A4", 2016, "1HGCM82633A555555", "Black", 64000, 2200, "Petrol", "Manual", "UVW789", "Available"));
            vehicles.add(new VehicleEntity(null, "Kia", "Sorento", 2018, "1HGCM82633A666666", "White", 58000, 3000, "Diesel", "Automatic", "XYZ123", "Available"));
            vehicles.add(new VehicleEntity(null, "Hyundai", "Tucson", 2015, "1HGCM82633A777777", "Blue", 72000, 2400, "Hybrid", "Automatic", "ABC456", "Maintenance"));
            vehicles.add(new VehicleEntity(null, "Mercedes", "C-Class", 2019, "1HGCM82633A888888", "Gray", 36000, 1800, "Electric", "Automatic", "DEF789", "Rented"));
            vehicles.add(new VehicleEntity(null, "Volkswagen", "Passat", 2020, "1HGCM82633A999999", "Silver", 45000, 2000, "Petrol", "Manual", "GHI123", "Available"));
            vehicles.add(new VehicleEntity(null, "Mazda", "CX-5", 2017, "1HGCM82633A000000", "Red", 61000, 2500, "Diesel", "Automatic", "JKL456", "Maintenance"));
            vehicles.add(new VehicleEntity(null, "Lexus", "RX", 2021, "1HGCM82633A111112", "White", 29000, 3500, "Hybrid", "Automatic", "MNO789", "Available"));
            vehicles.add(new VehicleEntity(null, "Subaru", "Outback", 2016, "1HGCM82633A222223", "Green", 74000, 2200, "Petrol", "Manual", "PQR123", "Rented"));
            vehicles.add(new VehicleEntity(null, "Jeep", "Wrangler", 2018, "1HGCM82633A333334", "Black", 48000, 3600, "Diesel", "Automatic", "STU456", "Available"));
            vehicleRepository.saveAll(vehicles);
        }
    }
}
