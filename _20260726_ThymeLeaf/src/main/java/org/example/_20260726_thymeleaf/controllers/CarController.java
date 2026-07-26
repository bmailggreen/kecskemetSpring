package org.example._20260726_thymeleaf.controllers;

import org.example._20260726_thymeleaf.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute(
                "title", "Autó Menedzser");
        //System.out.println(carService.cars);
        model.addAttribute(
                "cars", carService.cars);
        return "cars";
    }

}
