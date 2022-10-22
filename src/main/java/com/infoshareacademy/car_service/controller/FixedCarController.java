package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.service.BrokenCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "fixed/car")
public class FixedCarController {

    private final BrokenCarService carService;

    @GetMapping("/{id}")
    public String getFixedCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.changeIsFixedToTrue(id));
        carService.saveToFileFixedCars();
        carService.saveToFileBrokenCars();
        return "fixed-car";
    }

    @GetMapping("/table")
    public String getAllFixedCars(Model model) {
        model.addAttribute("car", carService.getListOfFixedCars());
        return "fixed-cars-table";
    }
}