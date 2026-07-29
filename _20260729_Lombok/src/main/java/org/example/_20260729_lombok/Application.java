package org.example._20260729_lombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Car2 car = new Car2();
        Car2 car2 = new Car2("Toyota", 230, "white");
        car.setType("Trabant");

        Car2 car4 =
        Car2.builder()
                .color("piros")
                .speed(123)
                .build();
        System.out.println(car4);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
