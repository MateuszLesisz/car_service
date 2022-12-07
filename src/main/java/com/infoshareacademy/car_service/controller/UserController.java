package com.infoshareacademy.car_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

    @GetMapping("login")
    public String getCarForm() {
        return "register-page";
    }
}
