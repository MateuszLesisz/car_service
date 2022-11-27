package com.infoshareacademy.car_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarServiceController {

    @GetMapping
    public String welcomePage() {
        return "register-page";
    }

    @GetMapping("welcomePage")
    public String afterLoginPage() {
        return "afterLoginPage";
    }
}