package org.example._20260726_thymeleaf.controllers;

import org.example._20260726_thymeleaf.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
public class TestController {

    @GetMapping("/dataResponse")
    @ResponseBody
    public String getData() {
        String data = "Sziasztok! Ez egy szép nap!";
        return data;
    }

    @GetMapping("/jsonResponse")
    @ResponseBody
    public List<Car> getJsonData() {
        List<Car> cars = List.of(
                new Car("Chevrolet", 230, "blue", true),
                new Car("BMW", 50, "white", true),
                new Car("Trabant", 130, "black", false)
        );
        return cars;
    }

    @GetMapping("/ownHtmlResponse")
    @ResponseBody
    public String getHTMLMyOwn() {
        String data = """
                <!DOCTYPE html>
                <html>
                    <head>
                    </head>
                    <body>
                        <p>Helló Világ!</p>
                        <ul>
                            <li>Egyes</li>
                            <li>Kettes</li>
                            <li>Hármas</li>
                        </ul>
                    </body>
                </html>
                """;
        return data;
    }

    @GetMapping("/htmlResponse")
    public String getHtml() {
        return "proba";
    }


}




