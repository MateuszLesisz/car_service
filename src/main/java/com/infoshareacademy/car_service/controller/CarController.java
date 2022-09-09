package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.repository.CarRepository;
import com.infoshareacademy.car_service.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarRepository carRepository;

    @GetMapping
    public String welcomePage() {
        return "welcome-page";
    }

    @GetMapping("broken/car/{id}")
    public String getBrokenCar(@PathVariable Long id, Model model) {
        model.addAttribute("cars", carRepository.findById(id));
        return "broken-car";
    }

    @GetMapping("broken/cars/table")
    public String getAllBrokenCars(Model model) {
        model.addAttribute("car", carService.getListOfBrokenCars(false));
        return "broken-cars-table";
    }

    @GetMapping("fixed/cars/table")
    public String getAllFixedCars(Model model) {
        model.addAttribute("car", carService.getListOfBrokenCars(true));
        return "fixed-cars-table";
    }

    @GetMapping("/cars/new")
    public String getCarForm(Model model) {
        model.addAttribute("car", new CarDto());
        return "addForm";
    }

    @PostMapping(value = "/cars/new")
    public String sendCar(@Valid @ModelAttribute("car") CarDto carDto,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addForm";
        }
        carService.create(carDto);
        return "addForm-success";
    }
}