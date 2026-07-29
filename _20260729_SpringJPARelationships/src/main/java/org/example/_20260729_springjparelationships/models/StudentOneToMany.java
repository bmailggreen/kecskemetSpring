package org.example._20260729_springjparelationships.models;

import jakarta.persistence.*;

@Entity
public class StudentOneToMany {
    @Id
    @GeneratedValue
    Integer id;

    String name;
    Double gradeAverage;

    @ManyToOne
    @JoinColumn(name = "teacher_ref")
    private TeacherOneToMany teacher;

    public StudentOneToMany() {
    }

    public StudentOneToMany(Integer id, String name, Double gradeAverage) {
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

    public TeacherOneToMany getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherOneToMany teacher) {
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
