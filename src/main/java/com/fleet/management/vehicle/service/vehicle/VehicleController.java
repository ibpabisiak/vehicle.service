package com.fleet.management.vehicle.service.vehicle;

import com.fleet.management.vehicle.service.vehicle.dtos.VehicleDto;
import com.fleet.management.vehicle.service.vehicle.dtos.VehicleShortDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vehicles")
@CrossOrigin
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.ok(vehicleService.upsert(vehicleDto));
    }

    @GetMapping
    public ResponseEntity<List<VehicleShortDto>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("vehicleId") UUID vehicleId) {
        return ResponseEntity.ok(vehicleService.getVehicle(vehicleId));
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("vehicleId") UUID vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok().build();
    }

}
