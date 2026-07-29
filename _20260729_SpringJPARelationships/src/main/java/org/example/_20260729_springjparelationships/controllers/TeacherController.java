package org.example._20260729_springjparelationships.controllers;

import org.example._20260729_springjparelationships.models.TeacherManyToMany;
import org.example._20260729_springjparelationships.repositories.TeacherManyToManyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherManyToManyRepository teacherRepository;

    @GetMapping("/teachers")
    @ResponseBody
    public List<TeacherManyToMany> getTeachers() {
        return (List<TeacherManyToMany>) teacherRepository.findAll();
    }
}