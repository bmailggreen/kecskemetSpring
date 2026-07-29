package org.example._20260729_springjparelationships.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class StudentOneToOne {
    @Id
    @GeneratedValue
    Integer id;

    String name;
    Double gradeAverage;

    @OneToOne(mappedBy = "student") //Így nem kellene hogy legyen
    // plusz mező sem a student táblában!
    TeacherOneToOne teacher;

    public StudentOneToOne() {
    }

    public StudentOneToOne(Integer id, String name, Double gradeAverage) {
        this.id = id;
        this.name = name;
        this.gradeAverage = gradeAverage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(Double gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public TeacherOneToOne getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherOneToOne teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "StudentOneToOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gradeAverage=" + gradeAverage +
                '}';
    }
}
