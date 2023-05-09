package com.learn2code.api.vehicle.details.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model_year")
    private String modelYear;
    @NotBlank(message = "* Brand name is required")
    @Column(name = "brand_name")
    private String brandName;
    @NotBlank(message = "* Model name is required")
    @Size(min = 3, max = 15, message = "Model name should be between 3-15 characters")
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "trim_type")
    private String trimType;
    @Column(name = "body_type")
    private String bodyType;
    @Column(name = "price")
    private double price;
    @Column(name = "miles")
    private int miles;
    @Column(name = "interest_rate")
    private double interestRate;
    @Column(name = "location")
    private String location;
    @Column(name = "vehicle_description")
    private String description;
    @Column(name = "seller_name")
    private String sellerName;
    @Column(name = "seller_phone")
    private String sellerPhone;
}
