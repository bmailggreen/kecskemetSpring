package org.example._20260729_springjparelationships.models;

import jakarta.persistence.*;
import org.example._20260729_springjparelationships.repositories.StudentOneToOneRepository;

import java.util.List;
import java.util.Set;

@Entity
public class TeacherOneToMany {
    @Id
    @GeneratedValue
    Integer id;

    String name;

/*
    @OneToMany(
            cascade = {CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            mappedBy = "teacher"
    )
 */

    @OneToMany(mappedBy = "teacher")
    Set<StudentOneToMany> students;
//    List<StudentOneToMany> students;

    public TeacherOneToMany() {
    }

    public TeacherOneToMany(Integer id, String name) {
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

    public Set<StudentOneToMany> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentOneToMany> students) {
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
