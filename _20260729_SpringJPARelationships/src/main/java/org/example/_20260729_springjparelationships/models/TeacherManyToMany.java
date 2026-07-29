package org.example._20260729_springjparelationships.models;

import jakarta.persistence.*;
import org.example._20260729_springjparelationships.repositories.StudentOneToOneRepository;

import java.util.Set;

@Entity
public class TeacherManyToMany {
    @Id
    @GeneratedValue
    Integer id;

    String name;

    @ManyToMany
    @JoinTable(name = "campus_connection",
            joinColumns = @JoinColumn(
                    name = "the_student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "the_teacher_id", referencedColumnName = "id")
    )
    Set<StudentManyToMany> students;

    public TeacherManyToMany() {
    }

    public TeacherManyToMany(Integer id, String name) {
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

    public Set<StudentManyToMany> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentManyToMany> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "TeacherOneToOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
