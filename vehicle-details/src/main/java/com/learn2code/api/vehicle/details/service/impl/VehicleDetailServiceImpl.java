package com.learn2code.api.vehicle.details.service.impl;

import com.learn2code.api.vehicle.details.entities.VehicleDetail;
import com.learn2code.api.vehicle.details.exception.VehicleNotSavedException;
import com.learn2code.api.vehicle.details.mapper.VehicleDetailMapper;
import com.learn2code.api.vehicle.details.payload.VehicleDetailDto;
import com.learn2code.api.vehicle.details.repositories.VehicleDetailRepository;
import com.learn2code.api.vehicle.details.service.VehicleDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleDetailServiceImpl implements VehicleDetailService {

    private VehicleDetailRepository vehicleDetailRepository;
    private VehicleDetailMapper vehicleDetailMapper;

    @Override
    public VehicleDetailDto saveVehicleDetails(VehicleDetailDto vehicleDetailDto) {

        try {
            VehicleDetail vehicleDetail = vehicleDetailMapper.mapToVehicleDetail(vehicleDetailDto);
            VehicleDetail savedVehicleDetail = vehicleDetailRepository.save(vehicleDetail);
            return vehicleDetailMapper.mapToVehicheDetailDto(savedVehicleDetail);
        }catch (Exception ex) {
            throw new VehicleNotSavedException("Unable to save vehicle in DB. Got error " +ex.getMessage());
        }

    }
}
