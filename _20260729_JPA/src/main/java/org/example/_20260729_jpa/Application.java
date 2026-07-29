package org.example._20260729_jpa;

import org.example._20260729_jpa.models.Person;
import org.example._20260729_jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
//        Person person = new Person(1L, "Józsi");
/*
        Person person = new Person();
        person.setName("Józsi");
        personRepository.save(person);
*/

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {

            Person person = new Person();
            person.setName("Józsi");
            person.setAge( rand.nextInt(30) + 6 );
            personRepository.save(person);
        }

        /*
        List<Person> persons = personRepository.findAll();
        persons.forEach(System.out::println);
         */

//        List<Person> personList1 = personRepository.findAllByNameContaining("al");
/*
        List<Person> personList1 = personRepository.findAllByNameContaining("zsi");
        System.out.println(personList1);
*/
        Person person2 = personRepository.findFirstByAgeBetween(20, 25);
        System.out.println(person2);

        List<Person> personList2 = personRepository.findAllByNameContainingAndAgeBetween("zsi", 23, 28);
        System.out.println(personList2);

        List<Person> personList3 = personRepository.findAllByNameJozsi();
        System.out.println(personList3);

        List<Person> personList4 = personRepository.findByNameNative("Józsi");
        System.out.println(personList4);

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
