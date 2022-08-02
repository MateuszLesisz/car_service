package com.infoshareacademy.car_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @GetMapping
    public String welcomePage() {
        return "welcome-page";
    }

    @GetMapping("cars")
    public String getCars() {
        return "cars";
    }
}
