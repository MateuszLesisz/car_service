package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String welcomePage() {
        return "welcome-page";
    }

    @GetMapping("cars")
    public String getCars() {
        return "cars";
    }

    @GetMapping("/cars/new")
    public String getCar(Model model) {
        model.addAttribute("car", new CarDto());
        return "addForm";
    }

    @PostMapping(value ="/cars/new")
    public String addCar(@ModelAttribute ("car") CarDto carDto) {
        carService.create(carDto);
        return "addForm-succes";

    }
}
