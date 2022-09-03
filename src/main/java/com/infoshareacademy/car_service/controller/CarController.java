package com.infoshareacademy.car_service.controller;

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
import java.util.UUID;

@Controller
@AllArgsConstructor
public class CarController {

    private final CarService carService;
    private final CarRepository carRepository;

    @GetMapping
    public String welcomePage() {
        return "welcome-page";
    }

    @GetMapping("car/{id}")
    public String getCars(@PathVariable UUID id, Model model) {
        model.addAttribute("cars", carRepository.findById(id));
        return "car";
    }

    @GetMapping("/cars/table")
    public String getAllCars(Model model) {
        model.addAttribute("car", carRepository.findAll());
        return "cars-table";
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