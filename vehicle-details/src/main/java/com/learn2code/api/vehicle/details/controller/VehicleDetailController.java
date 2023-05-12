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

    @GetMapping("/{vehicleId}")
    public VehicleDetailDto getVehicleDetailById(@PathVariable int vehicleId) {
        return vehicleDetailService.getVehicleById(vehicleId);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<String> deleteVehicleDetailsById(@PathVariable int vehicleId) {
        vehicleDetailService.deleteVehicleDetailsById(vehicleId);
        return new ResponseEntity<>("Vehicle details deleted successfully with ID- "+vehicleId,HttpStatus.OK);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleDetailDto> updateVehicleById(@RequestBody VehicleDetailDto vehicleDetailDto,
                                                              @PathVariable int vehicleId) {
        VehicleDetailDto savedVehicle =
                vehicleDetailService.updateVehicleDetails(vehicleDetailDto, vehicleId);
        return ResponseEntity.status(HttpStatus.OK).body(savedVehicle);

    }
}
