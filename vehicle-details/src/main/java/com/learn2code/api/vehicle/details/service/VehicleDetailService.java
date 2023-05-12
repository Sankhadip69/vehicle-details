package com.learn2code.api.vehicle.details.service;

import com.learn2code.api.vehicle.details.payload.VehicleDetailDto;

import java.util.List;

public interface VehicleDetailService {

    VehicleDetailDto saveVehicleDetails(VehicleDetailDto vehicleDetailDto);

    List<VehicleDetailDto> fetchAllVehicleDetails();

    VehicleDetailDto getVehicleById(int vehicleId);

    void  deleteVehicleDetailsById(int vehicleId);

    VehicleDetailDto updateVehicleDetails(VehicleDetailDto vehicleDetailDto, int vehicleId);
}
