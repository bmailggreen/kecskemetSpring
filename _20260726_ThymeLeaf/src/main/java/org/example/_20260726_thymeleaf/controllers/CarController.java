package org.example._20260726_thymeleaf.controllers;

import org.example._20260726_thymeleaf.models.Car;
import org.example._20260726_thymeleaf.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/addCar")
//    @ResponseBody
    private String addCar(/*Model model, */
            /*@ModelAttribute*/ Car car) {
        //System.out.println(car);
        carService.cars.add(car);
//        model.addAttribute("cars", carService.cars);
//        return "cars";
//        return "Adom a kocsikat";
        return "redirect:/";
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute(
                "title", "Autó Menedzser");
        //System.out.println(carService.cars);
        model.addAttribute(
                "cars", carService.cars);
        model.addAttribute(
                "car", new Car("Toyota", 230, "Silver"));
        return "cars";
    }

}
