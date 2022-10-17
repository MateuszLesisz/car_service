package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.Model.BrokenCar;
import com.infoshareacademy.car_service.dto.BrokenCarDto;
import com.infoshareacademy.car_service.repository.BrokenCarRepository;
import com.infoshareacademy.car_service.service.BrokenCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class BrokenCarController {

    private final BrokenCarService brokenCarService;
    private final BrokenCarRepository brokenCarRepository;

    @GetMapping
    public String welcomePage() {
        return "welcome-page";
    }

    @GetMapping("broken/car/{id}")
    public String getBrokenCar(@PathVariable Long id, Model model) {
        model.addAttribute("cars", brokenCarRepository.findById(id));
        return "broken-car";
    }

    @GetMapping("fixed/car/{id}")
    public String getFixedCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", brokenCarService.changeIsFixedToTrue(id));
        brokenCarService.deleteFromBrokenCars(id);
        return "fixed-car";
    }

    @GetMapping("broken/cars/table")
    public String getAllBrokenCars(Model model) {
        model.addAttribute("car", brokenCarService.getListOfBrokenCars(false));
        return "broken-cars-table";
    }

    @GetMapping("fixed/cars/table")
    public String getAllFixedCars(Model model) {
        model.addAttribute("car", brokenCarService.getListOfFixedCars(true));
        return "fixed-cars-table";
    }

    @GetMapping("/cars/new")
    public String getCarForm(Model model) {
        model.addAttribute("car", new BrokenCarDto());
        return "addForm";
    }

    @PostMapping("/cars/new")
    public String sendCar(@Valid @ModelAttribute("car") BrokenCarDto brokenCarDto,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addForm";
        }
        brokenCarService.createBrokenCar(brokenCarDto);
        brokenCarService.saveToFile();
        return "addForm-success";
    }

    @Transactional
    @PatchMapping("car/{id}")
    public String toggleCar(@PathVariable Long id) {
        if (!brokenCarRepository.existsById(id)) {
            return "broken-car";
        }
        brokenCarRepository.findById(id)
                .ifPresent(brokenCar -> brokenCar.setIsFixed(true));
        return "fixed-car";
    }

    @GetMapping("search/broken/car")
    public String searchBrokenCar(Model model,String keyword) {
        List<BrokenCar> brokenCars = brokenCarService.getCarByRegistrationNumber(keyword);
        model.addAttribute("car", brokenCars);
        return "broken-cars-table";
    }
}