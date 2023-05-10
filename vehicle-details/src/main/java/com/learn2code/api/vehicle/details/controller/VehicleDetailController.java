package com.learn2code.api.vehicle.details.controller;

import com.learn2code.api.vehicle.details.exception.MandatoryFieldsMissingException;
import com.learn2code.api.vehicle.details.payload.VehicleDetailDto;
import com.learn2code.api.vehicle.details.payload.VehicleDetailPayLoad;
import com.learn2code.api.vehicle.details.service.VehicleDetailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/vehicle-details")
public class VehicleDetailController {

    private VehicleDetailService vehicleDetailService;

    @PostMapping
    public ResponseEntity<VehicleDetailDto> saveVehicleDetails(@Valid @RequestBody VehicleDetailDto vehicleDetailDto,
                                                               BindingResult result) {
        if(result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            String allErrors = "";
            for(ObjectError error : errorList) {
                allErrors += error.getDefaultMessage() + ",";
            }
            throw  new MandatoryFieldsMissingException(allErrors);
        }
        VehicleDetailDto saveVehicleDetail = vehicleDetailService.saveVehicleDetails(vehicleDetailDto);
        return new ResponseEntity<>(saveVehicleDetail, HttpStatus.CREATED);
    }
    
    @GetMapping
    public VehicleDetailPayLoad getAllVehicleDetails() {
       List<VehicleDetailDto> savedVehicles = vehicleDetailService.fetchAllVehicleDetails();
       return new VehicleDetailPayLoad(savedVehicles);
    }

}
