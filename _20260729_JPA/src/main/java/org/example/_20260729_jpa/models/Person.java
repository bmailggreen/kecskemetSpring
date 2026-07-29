package org.example._20260729_jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue
    Long id;

    String name;
    Integer age;

    @Transient //Transient-re nincs adatbázis leképezés
    Date fetchedAt;

    public Person() {
        fetchedAt = new Date();
    }

    public Person(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
        fetchedAt = new Date();
    }

    //Ez biztos nem lesz az adatbázisban leképezve.
    //De JSON válaszban igen a függvény neve és az eredménye.
    //Ha nem szeretnénk akkor JSONIgnore-t írjunk ide.
    @JsonIgnore
    public boolean isAdult() {
        return this.age >= 18;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", fetchedAt=" + fetchedAt +
                '}';
    }
}
