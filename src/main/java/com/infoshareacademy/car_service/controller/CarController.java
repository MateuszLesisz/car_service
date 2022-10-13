package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.Model.Car;
import com.infoshareacademy.car_service.dto.CarDto;
import com.infoshareacademy.car_service.repository.CarRepository;
import com.infoshareacademy.car_service.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("fixed/car/{id}")
    public String getFixedCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.changeIsFixedToTrue(id));
        return "fixed-car";
    }

    @GetMapping("broken/cars/table")
    public String getAllBrokenCars(Model model) {
        model.addAttribute("car", carService.getListOfBrokenCars(false));
        return "broken-cars-table";
    }

    @GetMapping("fixed/cars/table")
    public String getAllFixedCars(Model model) {
        model.addAttribute("car", carService.getListOfFixedCars(true));
        return "fixed-cars-table";
    }

    @GetMapping("/cars/new")
    public String getCarForm(Model model) {
        model.addAttribute("car", new CarDto());
        return "addForm";
    }

    @PostMapping("/cars/new")
    public String sendCar(@Valid @ModelAttribute("car") CarDto carDto,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addForm";
        }
        carService.createCar(carDto);
        carService.saveToFile();
        return "addForm-success";
    }

    @Transactional
    @PatchMapping("car/{id}")
    public String toggleCar(@PathVariable Long id) {
        if (!carRepository.existsById(id)) {
            return "broken-car";
        }
        carRepository.findById(id)
                .ifPresent(car -> car.setIsFixed(true));
        return "fixed-car";
    }

    @PostMapping("search/broken/car")
    public String searchBrokenCar(@Valid @ModelAttribute("car") CarDto carDto) {
        carService.getCarByRegistrationNumber(carDto.getRegistrationNumber());
        return "broken-cars-table";
    }
}