package com.infoshareacademy.car_service.security;

import com.infoshareacademy.car_service.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SsoController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) throws ServletException {
        request.logout();
        model.addAttribute("user", new UserDto());
        return "register-page";
    }
}
