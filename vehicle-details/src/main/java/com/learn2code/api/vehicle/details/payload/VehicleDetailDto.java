package com.learn2code.api.vehicle.details.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetailDto {

    private int id;
    private String modelYear;
    private String brandName;
    private String modelName;
    private String trimType;
    private String bodyType;
    private double price;
    private int miles;
    private double interestRate;
    private String location;
    private String description;
    private String sellerName;
    private String sellerPhone;
}
