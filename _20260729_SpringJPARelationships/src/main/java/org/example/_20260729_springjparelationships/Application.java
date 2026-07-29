package org.example._20260729_springjparelationships;

import org.example._20260729_springjparelationships.models.*;import org.example._20260729_springjparelationships.repositories.*;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.CommandLineRunner;import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import java.util.HashSet;import java.util.List;import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    StudentOneToOneRepository studentOneToOneRepository;
    @Autowired
    TeacherOneToOneRepository teacherOneToOneRepository;
    @Autowired
    StudentOneToManyRepository studentOneToManyRepository;
    @Autowired
    TeacherOneToManyRepository teacherOneToManyRepository;
    @Autowired
    StudentManyToManyRepository studentManyToManyRepository;
    @Autowired
    TeacherManyToManyRepository teacherManyToManyRepository;


    private void oneToOneRelationship() {
        //OneToOne
        StudentOneToOne jill = new StudentOneToOne();
        jill.setName("Jill Jungle");
        jill.setGradeAverage(3.4);
        studentOneToOneRepository.save(jill);
        //Előbb el kell menteni mint aki rá hivatkozik!

        TeacherOneToOne john = new TeacherOneToOne();
        john.setName("John Smith");
        john.setStudent(jill);
        teacherOneToOneRepository.save(john);

        jill.setTeacher(john);
        studentOneToOneRepository.save(jill);
    }

    private void oneToManyRelationship() {
        //OneToMany
        StudentOneToMany jill = new StudentOneToMany();
        jill.setName("Jill Jungle");
        jill.setGradeAverage(3.4);
        studentOneToManyRepository.save(jill);
        //Előbb el kell menteni mint aki rá hivatkozik!

        StudentOneToMany carl = new StudentOneToMany();
        carl.setName("Carl Cartridge");
        carl.setGradeAverage(4.5);
        studentOneToManyRepository.save(carl);
        //Előbb el kell menteni mint aki rá hivatkozik!

        Set<StudentOneToMany> students = new HashSet<>();
        students.add(jill);
        students.add(carl);

        TeacherOneToMany john = new TeacherOneToMany();
        john.setName("John Smith");
        john.setStudents(students);
        jill.setTeacher(john);
        carl.setTeacher(john);
        teacherOneToManyRepository.save(john);
        studentOneToManyRepository.save(jill);
        studentOneToManyRepository.save(carl);

        List<TeacherOneToMany> teachers =
                (List<TeacherOneToMany>) teacherOneToManyRepository.findAll();
        System.out.println(teachers);

        List<StudentOneToMany> studentsResult =
                (List<StudentOneToMany>) studentOneToManyRepository.findAll();
        System.out.println(studentsResult);

    }

    private void manyToManyRelationship() {
        //ManyToMany
        StudentManyToMany jill = new StudentManyToMany();
        jill.setName("Jill Jungle");
        jill.setGradeAverage(3.4);

        StudentManyToMany carl = new StudentManyToMany();
        carl.setName("Carl Cartridge");
        carl.setGradeAverage(4.5);

        Set<StudentManyToMany> students = new HashSet<>();
        students.add(jill);
        students.add(carl);

        studentManyToManyRepository.save(jill);
        studentManyToManyRepository.save(carl);

        TeacherManyToMany john = new TeacherManyToMany();
        john.setName("John Smith");
        john.setStudents(students);

        TeacherManyToMany jonathan = new TeacherManyToMany();
        jonathan.setName("Jonathan Stone");
        jonathan.setStudents(students);

        Set<TeacherManyToMany> teachers = new HashSet<>();
        teachers.add(john);
        teachers.add(jonathan);

        teacherManyToManyRepository.save(john);
        teacherManyToManyRepository.save(jonathan);

        jill.setTeachers(teachers);
        carl.setTeachers(teachers);
        studentManyToManyRepository.save(jill);
        studentManyToManyRepository.save(carl);

        List<TeacherManyToMany> teachersResult2 =
                (List<TeacherManyToMany>) teacherManyToManyRepository.findAll();
        System.out.println(teachersResult2);
    }

    @Override
    public void run(String... args) throws Exception {
        //oneToOneRelationship();
        //oneToManyRelationship();
        manyToManyRelationship();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
