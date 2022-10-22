package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.repository.FixedCarRepository;
import com.infoshareacademy.car_service.service.BrokenCarService;
import com.infoshareacademy.car_service.service.FixedCarService;
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

    private final BrokenCarService brokenCarService;
    private final FixedCarService fixedCarService;



    @GetMapping("/{id}")
    public String getFixedCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", brokenCarService.changeIsFixedToTrue(id));
        fixedCarService.saveToFileFixedCars();
        brokenCarService.saveToFileBrokenCars();
        return "fixed-car";
    }

    @GetMapping("/table")
    public String getAllFixedCars(Model model) {
        model.addAttribute("car", fixedCarService.getListOfReversedFixedCars());
        return "fixed-cars-table";
    }
}