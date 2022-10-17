package com.infoshareacademy.car_service.dto;

import com.infoshareacademy.car_service.Model.BrokenCar;
import lombok.Data;

@Data
public class FixedCarDto {

    private Long id;

    private BrokenCar brokenId;

    private boolean isFixed;
}
