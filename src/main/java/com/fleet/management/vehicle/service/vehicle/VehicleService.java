package com.fleet.management.vehicle.service.vehicle;

import com.fleet.management.vehicle.service.vehicle.dtos.VehicleDto;
import com.fleet.management.vehicle.service.vehicle.dtos.VehicleShortDto;
import com.fleet.management.vehicle.service.vehicle.models.VehicleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public VehicleDto upsert(VehicleDto dto) {
        VehicleEntity vehicleEntity;
        if (dto.getId() == null) {
            log.info("Creating a new vehicle..");
            vehicleEntity = modelMapper.map(dto, VehicleEntity.class);
        } else {
            log.info("Updating existing vehicle: {}", dto.getId());
            vehicleEntity = vehicleRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));
            modelMapper.map(dto, vehicleEntity);
        }

        log.info("Saving changes to the database..");
        var saved = vehicleRepository.save(vehicleEntity);
        log.info("Saved changes successfully: {}", saved.getId());
        return modelMapper.map(saved, VehicleDto.class);
    }

    @Transactional(readOnly = true)
    public List<VehicleShortDto> getAllVehicles() {
        log.info("Loading all vehicles from database..");
        return vehicleRepository.findAll().stream().map(e -> modelMapper.map(e, VehicleShortDto.class)).toList();
    }

    @Transactional(readOnly = true)
    public VehicleDto getVehicle(UUID id) {
        log.info("Loading a vehicle from database: {}", id);
        var entity = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return modelMapper.map(entity, VehicleDto.class);
    }

    @Transactional
    public void deleteVehicle(UUID id) {
        log.info("Deleting a vehicle from database: {}", id);
        vehicleRepository.deleteById(id);
    }

}
