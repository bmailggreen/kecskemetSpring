package org.example._20260726_thymeleaf.models;

public class Car {
    String type;
    int speed;
    String color;
    boolean isHibrid;
    String size;
    boolean canFly;

    public Car() {
    }

    public Car(String type, int speed, String color, boolean isHibrid, String size, boolean canFly) {
        this.type = type;
        this.speed = speed;
        this.color = color;
        this.isHibrid = isHibrid;
        this.size = size;
        this.canFly = canFly;
    }

    public Car(String type, int speed, String color, boolean isHibrid) {
        this.type = type;
        this.speed = speed;
        this.color = color;
        this.isHibrid = isHibrid;
        this.size = "small";
        this.canFly = false;
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

    public boolean isHibrid() {
        return isHibrid;
    }

    public void setHibrid(boolean hibrid) {
        isHibrid = hibrid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                ", isHibrid=" + isHibrid +
                ", size='" + size + '\'' +
                ", canFly=" + canFly +
                '}';
    }
}
