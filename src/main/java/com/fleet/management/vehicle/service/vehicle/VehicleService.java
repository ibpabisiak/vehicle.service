package com.fleet.management.vehicle.service.vehicle;

import com.fleet.management.vehicle.service.vehicle.dtos.VehicleDto;
import com.fleet.management.vehicle.service.vehicle.dtos.VehicleShortDto;
import com.fleet.management.vehicle.service.vehicle.models.VehicleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleDto upsert(VehicleDto vehicleDto) {
        VehicleEntity vehicleEntity;
        if (StringUtils.isEmpty(vehicleDto.getId())) {
            log.info("Creating a new vehicle..");
            vehicleEntity = modelMapper.map(vehicleDto, VehicleEntity.class);
        } else {
            log.info("Updating existing vehicle: {}", vehicleDto.getId());
            vehicleEntity = vehicleRepository.findById(vehicleDto.getId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));
            modelMapper.map(vehicleDto, vehicleEntity);
        }

        log.info("Saving changes to the database..");
        var saved = vehicleRepository.save(vehicleEntity);
        log.info("Saved changes successfully: {}", saved.getId());
        return modelMapper.map(saved, VehicleDto.class);
    }

    public List<VehicleShortDto> getAllVehicles() {
        log.info("Loading all vehicles from database..");
        return vehicleRepository.findAll().stream().map(e -> modelMapper.map(e, VehicleShortDto.class)).toList();
    }

    public VehicleDto getVehicle(String id) {
        log.info("Loading a vehicle from database: {}", id);
        var entity = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return modelMapper.map(entity, VehicleDto.class);
    }

    public void deleteVehicle(String id) {
        log.info("Deleting a vehicle from database: {}", id);
        vehicleRepository.deleteById(id);
    }

}
