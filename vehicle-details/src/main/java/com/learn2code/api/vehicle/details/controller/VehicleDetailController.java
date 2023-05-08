package com.learn2code.api.vehicle.details.controller;

import com.learn2code.api.vehicle.details.payload.VehicleDetailDto;
import com.learn2code.api.vehicle.details.service.VehicleDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/vehicle-details")
public class VehicleDetailController {

    private VehicleDetailService vehicleDetailService;

    @PostMapping
    public ResponseEntity<VehicleDetailDto> saveVehicleDetails(@RequestBody VehicleDetailDto vehicleDetailDto) {
        VehicleDetailDto saveVehicleDetail = vehicleDetailService.saveVehicleDetails(vehicleDetailDto);
        return new ResponseEntity<>(saveVehicleDetail, HttpStatus.CREATED);
    }

}
