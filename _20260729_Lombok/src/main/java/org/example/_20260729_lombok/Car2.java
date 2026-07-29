package org.example._20260729_lombok;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Car2 {
    String type;
    Integer speed;
    String color;

    @Override
    public String toString() {
        return "Car2{" +
                "type='" + type + '\'' +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }
}
