package com.learn2code.api.vehicle.details.mapper;

import com.learn2code.api.vehicle.details.entities.VehicleDetail;
import com.learn2code.api.vehicle.details.payload.VehicleDetailDto;
import org.mapstruct.Mapper;

@Mapper
public interface VehicleDetailMapper {

    VehicleDetailDto mapToVehicheDetailDto(VehicleDetail vehicleDetail);

    VehicleDetail mapToVehicleDetail(VehicleDetailDto vehicleDetailDto);
}
