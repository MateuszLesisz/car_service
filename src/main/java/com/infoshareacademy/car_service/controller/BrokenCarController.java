package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.model.BrokenCar;
import com.infoshareacademy.car_service.repository.BrokenCarRepository;
import com.infoshareacademy.car_service.service.BrokenCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "broken/car")
public class BrokenCarController {

    private final BrokenCarRepository brokenCarRepository;
    private final BrokenCarService brokenCaService;

    @GetMapping("/{id}")
    public String getBrokenCar(@PathVariable Long id, Model model) {
        model.addAttribute("cars", brokenCarRepository.findById(id));
        return "broken-car";
    }

    @GetMapping("/table")
    public String getAllBrokenCars(Model model) {
        model.addAttribute("car", brokenCaService.getAllBrokenCars());
        return "broken-cars-table";
    }

    @GetMapping("/search")
    public String searchBrokenCar(Model model, String keyword) {
        List<BrokenCar> brokenCars = brokenCaService.getCarByRegistrationNumberAndIsFixed(keyword, false);
        model.addAttribute("car", brokenCars);
        return "broken-cars-table";
    }
}