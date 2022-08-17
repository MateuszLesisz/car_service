package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public String welcomePage() {
        return "welcome-page";
    }

    @GetMapping("car/{id}")
    public String getCars(@PathVariable Long id, Model model) {
        model.addAttribute("cars", carService.find(id));
        return "car";
    }

    @GetMapping("/cars")
    public String getCarForm(Model model) {
        model.addAttribute("car", new CarDto());
        return "addForm";
    }

    @PostMapping(value ="/cars")
    public String sendCar(@ModelAttribute ("car") CarDto carDto) {
        carService.create(carDto);
        return "addForm-success";
    }

    @GetMapping("/cars/table")
    public String getAllCars(Model model) {
        model.addAttribute("car", carService.findAll());
        return "cars-table";
    }
}