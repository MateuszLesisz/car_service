package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.repository.CarRepository;
import com.infoshareacademy.car_service.service.CarService;
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

    private final CarRepository carRepository;

    private final CarService carService;

    @GetMapping("/{id}")
    public String getBrokenCar(@PathVariable Long id, Model model) {
        model.addAttribute("cars", carRepository.findById(id));
        return "broken-car";
    }

    @GetMapping("/table")
    public String getAllBrokenCars(Model model) {
        model.addAttribute("car", carService.getListOfBrokenCars());
        return "broken-cars-table";
    }

    @GetMapping("/search")
    public String searchBrokenCar(Model model, String keyword) {
        List<Car> cars = carService.getCarByRegistrationNumberAndIsFixed(keyword, false);
        model.addAttribute("car", cars);
        return "broken-cars-table";
    }
}