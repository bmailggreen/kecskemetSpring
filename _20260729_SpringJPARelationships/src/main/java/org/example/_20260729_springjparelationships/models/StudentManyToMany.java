package org.example._20260729_springjparelationships.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class StudentManyToMany {
    @Id
    @GeneratedValue
    Integer id;

    String name;
    Double gradeAverage;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    Set<TeacherManyToMany> teachers;

    public StudentManyToMany() {
    }

    public StudentManyToMany(Integer id, String name, Double gradeAverage) {
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

    public Set<TeacherManyToMany> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TeacherManyToMany> teachers) {
        this.teachers = teachers;
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
