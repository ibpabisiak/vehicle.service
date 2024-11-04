package com.fleet.management.vehicle.service.config;

import com.fleet.management.vehicle.service.vehicle.dtos.VehicleDto;
import com.fleet.management.vehicle.service.vehicle.models.VehicleEntity;
import com.fleet.management.vehicle.service.vehicle.dtos.VehicleShortDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(VehicleEntity.class, VehicleDto.class);
        modelMapper.createTypeMap(VehicleEntity.class, VehicleShortDto.class);
        modelMapper.validate();

        return modelMapper;
    }

}
