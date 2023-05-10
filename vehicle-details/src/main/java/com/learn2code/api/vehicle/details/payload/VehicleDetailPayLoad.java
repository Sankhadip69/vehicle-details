package com.learn2code.api.vehicle.details.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetailPayLoad {

    List<VehicleDetailDto> vehicleDetailsList;
}
