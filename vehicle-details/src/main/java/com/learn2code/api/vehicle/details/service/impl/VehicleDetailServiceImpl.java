package com.learn2code.api.vehicle.details.service.impl;

import com.learn2code.api.vehicle.details.entities.VehicleDetail;
import com.learn2code.api.vehicle.details.exception.VehicleDetailsNotFound;
import com.learn2code.api.vehicle.details.exception.VehicleNotSavedException;
import com.learn2code.api.vehicle.details.mapper.VehicleDetailMapper;
import com.learn2code.api.vehicle.details.payload.VehicleDetailDto;
import com.learn2code.api.vehicle.details.repositories.VehicleDetailRepository;
import com.learn2code.api.vehicle.details.service.VehicleDetailService;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
        } catch (Exception ex) {
            throw new VehicleNotSavedException("Unable to save vehicle in DB. Got error " + ex.getMessage());
        }

    }

    @Override
    public List<VehicleDetailDto> fetchAllVehicleDetails() {
        List<VehicleDetail> dbVehicleDetails = vehicleDetailRepository.findAll();
        if (dbVehicleDetails.isEmpty()) {
            throw new VehicleDetailsNotFound("No vehicle details found in Database!");
        }
        return dbVehicleDetails.stream().map(vehicleDetailMapper::mapToVehicheDetailDto).collect(Collectors.toList());
    }

    @Override
    public VehicleDetailDto getVehicleById(int vehicleId) {
        Optional<VehicleDetail> optionalVehicleDetails = vehicleDetailRepository.findById(vehicleId);
        if (!optionalVehicleDetails.isPresent()) {
            throw new VehicleDetailsNotFound("No vehicle details found in database for vehicle ID- " + vehicleId);
        }
        return vehicleDetailMapper.mapToVehicheDetailDto(optionalVehicleDetails.get());
    }

    @Override
    public void deleteVehicleDetailsById(int vehicleId) {
        VehicleDetail vehicleDetail = vehicleDetailRepository.findById(vehicleId).orElseThrow(
                () -> new VehicleDetailsNotFound("No vehicle details found in database for vehicle ID- " + vehicleId)
        );
        vehicleDetailRepository.deleteById(vehicleId);
    }

    @Override
    public VehicleDetailDto updateVehicleDetails(VehicleDetailDto vehicleDetailDto, int vehicleId) {
        Optional<VehicleDetail> optionalVehicle = vehicleDetailRepository.findById(vehicleId);
        if (!optionalVehicle.isPresent()) {
            throw new VehicleDetailsNotFound("No vehicle details found in database for vehicle ID- " + vehicleId);
        }
        VehicleDetail vehicleDetail = optionalVehicle.get();
        if (vehicleDetailDto.getModelYear() != null && !vehicleDetailDto.getModelYear().isEmpty()) {
            vehicleDetail.setModelYear(vehicleDetailDto.getModelYear());
        }
        if (vehicleDetailDto.getBrandName() != null && !vehicleDetailDto.getBrandName().isEmpty()) {
            vehicleDetail.setBrandName(vehicleDetailDto.getBrandName());
        }
        if (vehicleDetailDto.getModelName() != null && !vehicleDetailDto.getModelName().isEmpty()) {
            vehicleDetail.setModelName(vehicleDetailDto.getModelName());
        }
        if (vehicleDetailDto.getPrice() != 0.0 && Objects.nonNull(vehicleDetailDto.getPrice())) {
            vehicleDetail.setPrice(vehicleDetailDto.getPrice());
        }
        if (vehicleDetailDto.getMiles() != 0 && Objects.nonNull(vehicleDetailDto.getMiles())) {
            vehicleDetail.setMiles(vehicleDetailDto.getMiles());
        }
        if (vehicleDetailDto.getInterestRate() != 0.0 && Objects.nonNull(vehicleDetailDto.getInterestRate())) {
            vehicleDetail.setInterestRate(vehicleDetailDto.getInterestRate());
        }
        if (vehicleDetailDto.getSellerName() != null && !vehicleDetailDto.getSellerName().isEmpty()) {
            vehicleDetail.setSellerName(vehicleDetailDto.getSellerName());
        }
        if (vehicleDetailDto.getSellerPhone() != null && !vehicleDetailDto.getSellerPhone().isEmpty()) {
            vehicleDetail.setSellerPhone(vehicleDetailDto.getSellerPhone());
        }
        vehicleDetail.setTrimType(vehicleDetailDto.getTrimType());
        vehicleDetail.setBodyType(vehicleDetailDto.getBodyType());
        vehicleDetail.setLocation(vehicleDetailDto.getLocation());
        vehicleDetail.setDescription(vehicleDetailDto.getDescription());

        return vehicleDetailMapper
                .mapToVehicheDetailDto(vehicleDetailRepository.save(vehicleDetail));
    }
}