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

            String[] brands = {"Toyota", "Ford", "Honda", "Chevrolet", "Nissan", "BMW", "Audi", "Kia", "Hyundai", "Mercedes", "Volkswagen", "Mazda", "Lexus", "Subaru", "Jeep", "Tesla", "Volvo", "Peugeot", "Renault", "Fiat"};
            String[] models = {"Model X", "Model Y", "Model Z", "Sedan", "SUV", "Hatchback", "Convertible", "Coupe", "Wagon", "Crossover"};
            String[] colors = {"Red", "Blue", "Black", "White", "Gray", "Silver", "Green", "Yellow", "Orange", "Brown"};
            String[] fuels = {"Petrol", "Diesel", "Hybrid", "Electric"};
            String[] transmissions = {"Manual", "Automatic"};
            String[] statuses = {"Available", "Rented", "Maintenance"};

            int year = 2010;
            int vinBase = 100000;
            int mileageBase = 30000;
            int engineBase = 1600;

            for (int i = 0; i < 107; i++) {
                String brand = brands[i % brands.length];
                String model = models[i % models.length];
                String color = colors[i % colors.length];
                String fuel = fuels[i % fuels.length];
                String transmission = transmissions[i % transmissions.length];
                String status = statuses[i % statuses.length];

                vehicles.add(new VehicleEntity(
                        null,
                        brand,
                        model,
                        year + (i % 15),
                        "1HGCM82633A" + (vinBase + i),
                        color,
                        mileageBase + (i * 5000),
                        engineBase + ((i % 5) * 200),
                        fuel,
                        transmission,
                        "PLT" + (100 + i),
                        status
                ));
            }

            vehicleRepository.saveAll(vehicles);
        }
    }
}
