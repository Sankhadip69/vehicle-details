package com.learn2code.api.vehicle.details.repositories;

import com.learn2code.api.vehicle.details.entities.VehicleDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailRepository extends JpaRepository<VehicleDetail, Integer> {
}
