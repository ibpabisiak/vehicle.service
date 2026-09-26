package com.fleet.management.vehicle.service.vehicle;

import com.fleet.management.vehicle.service.vehicle.models.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, UUID> {
}
