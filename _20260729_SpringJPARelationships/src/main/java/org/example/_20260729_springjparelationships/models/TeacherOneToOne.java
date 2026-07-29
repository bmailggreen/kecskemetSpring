package org.example._20260729_springjparelationships.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.example._20260729_springjparelationships.repositories.StudentOneToOneRepository;

@Entity
public class TeacherOneToOne {
    @Id
    @GeneratedValue
    Integer id;

    String name;

    @OneToOne
    StudentOneToOne student;

    public TeacherOneToOne() {
    }

    public TeacherOneToOne(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public StudentOneToOne getStudent() {
        return student;
    }

    public void setStudent(StudentOneToOne student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "TeacherOneToOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
