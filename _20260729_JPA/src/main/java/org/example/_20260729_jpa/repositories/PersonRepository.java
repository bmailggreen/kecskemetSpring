package org.example._20260729_jpa.repositories;

import org.example._20260729_jpa.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //JPQL -> Java Persistence Query Language

    //Query Method-nak vagy Derived Query Methodnak hívják
    List<Person> findAllByNameContaining(String subtext);

    Person findFirstByAgeBetween(int lower, int upper);

    List<Person> findAllByNameContainingAndAgeBetween(
            String subtext, int lower, int upper);

    /*
    Saját @Query, de:
    - A query helyett a value attribútumot használjuk (vagy el is hagyható).
    - Alapértelmezetten JPQL-t írunk, nem SQL-t.
    - JPQL-ben az entitás nevét és a mezőneveket használjuk,
    nem a tábla- és oszlopneveket.
     */
    //Ez a JPQL
    @Query("SELECT p FROM Person p WHERE p.name = 'Józsi'")
    List<Person> findAllByNameJozsi();

    @Query(
            value = "SELECT * FROM person WHERE name = :name",
            nativeQuery = true
    )
    List<Person> findByNameNative(@Param("name") String name);
}

/*
Query Methodhoz vagy Derived Query Methodhoz puska

findBy	findByName(String name)
readBy	readByEmail(String email)
getBy	getById(Long id)
existsBy	existsByEmail(String email)
countBy	countByStatus(Status status)
deleteBy	deleteByUsername(String username)
removeBy	removeByAgeLessThan(int age)

findByName
findByAgeGreaterThan
findByAgeLessThan
findByAgeBetween
findByNameLike
findByNameContaining
findByNameStartsWith
findByNameEndsWith
findByEmailIsNull
findByEmailIsNotNull
findByActiveTrue
findByActiveFalse
findByAgeIn
findByAgeNotIn
findByNameIgnoreCase

Rendezés
findByOrderByNameAsc()
findByOrderByAgeDesc()
Eredmény korlátozása
findFirstByOrderByIdDesc()
findTopBySalaryDesc()
findTop10ByOrderByAgeDesc()
Rendezés paraméterrel
List<User> findByAgeGreaterThan(int age, Sort sort);
Lapozás
Page<User> findByActiveTrue(Pageable pageable);

A Spring Data JPA dokumentációban ez a funkció Query Creation néven szerepel,
és felsorolja az összes támogatott kulcsszót
(Containing, StartingWith, Between, IsNull, GreaterThanEqual, stb.).
 */
