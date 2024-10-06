package ru.innopolis.java.homework019.tvapp.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class TV {
    private Long id;
    private String brand;
    private String model;
    private BigDecimal screenSize;
    private String resolution;
    private BigDecimal price;
    private Short warrantyYears;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TV() {
    }

    public TV(String brand, String model, BigDecimal screenSize, String resolution, BigDecimal price, Short warrantyYears) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.price = price;
        this.warrantyYears = warrantyYears;
    }

}
