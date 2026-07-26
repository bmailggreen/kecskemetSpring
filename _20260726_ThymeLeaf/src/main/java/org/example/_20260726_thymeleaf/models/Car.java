package org.example._20260726_thymeleaf.models;

public class Car {
    String type;
    int speed;
    String color;

    public Car() {
    }

    public Car(String type, int speed, String color) {
        this.type = type;
        this.speed = speed;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }
}
