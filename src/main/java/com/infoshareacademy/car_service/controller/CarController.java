package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.dto.BrokenCarDto;
import com.infoshareacademy.car_service.service.BrokenCarService;
import com.infoshareacademy.car_service.utils.SaveToFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class CarController {

    private final BrokenCarService carService;
    private final SaveToFile saveToFile;

    @GetMapping("/car/new")
    public String getCarForm(Model model) {
        model.addAttribute("car", new BrokenCarDto());
        return "addForm";
    }

    @PostMapping("/car/new")
    public String sendCar(@Valid @ModelAttribute("car") BrokenCarDto brokenCarDto,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addForm";
        }
        carService.createCar(brokenCarDto);
        saveToFile.saveToFileBrokenCars();
        return "addForm-success";
    }
}