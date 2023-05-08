package com.learn2code.api.vehicle.details.service.impl;

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
        return vehicleDetailMapper
                .mapToVehicheDetailDto(vehicleDetailRepository
                        .save(vehicleDetailMapper.mapToVehicleDetail(vehicleDetailDto)));
    }
}
