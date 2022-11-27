package com.infoshareacademy.car_service.controller;

import com.infoshareacademy.car_service.dto.UserDto;
import com.infoshareacademy.car_service.service.UserService;
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
public class UserController {

    private final UserService userService;

    @GetMapping("/user/new")
    public String getCarForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "addNewUserForm";
    }

    @PostMapping("/user/new")
    public String sendCar(@Valid @ModelAttribute("user") UserDto userDto,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addNewUserForm";
        }
        userService.createUser(userDto);
        return "addForm-success";
    }
}
