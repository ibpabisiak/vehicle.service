package com.fleet.management.vehicle.service.config;

import com.fleet.management.vehicle.service.vehicle.dtos.VehicleDto;
import com.fleet.management.vehicle.service.vehicle.dtos.VehicleShortDto;
import com.fleet.management.vehicle.service.vehicle.models.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(VehicleEntity.class, VehicleDto.class).addMappings(mappings -> {
            mappings.map(VehicleEntity::getMake, VehicleDto::setBrand);
        });
        modelMapper.createTypeMap(VehicleEntity.class, VehicleShortDto.class).addMappings(mappings -> {
            mappings.map(VehicleEntity::getMake, VehicleShortDto::setBrand);
        });
        modelMapper.validate();

        return modelMapper;
    }

}
