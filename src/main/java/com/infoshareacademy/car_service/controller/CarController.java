package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("car/{id}")
    public String getCars(@PathVariable Long id, Model model) {
        CarDto carDto = carService.find(id);
        model.addAttribute("cars", carDto);
        return "cars";
    }



    @GetMapping("/cars/new")
    public String getCarForm(Model model) {
        model.addAttribute("car", new CarDto());
        return "addForm";
    }

    @PostMapping(value ="/cars/new")
    public String sendCar(@ModelAttribute ("car") CarDto carDto) {
        carService.create(carDto);
        return "addForm-success";

    }
}
