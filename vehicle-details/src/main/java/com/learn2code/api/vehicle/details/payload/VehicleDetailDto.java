package com.learn2code.api.vehicle.details.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetailDto {

    private int id;
    private String modelYear;
    @NotBlank(message = "* Brand name is required")
    private String brandName;
    @NotBlank(message = "* Model name is required")
    @Size(min = 3, max = 15, message = "Model name should be between 3-15 characters")
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
