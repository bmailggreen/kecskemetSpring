package org.example._20260729_springjparelationships.repositories;

import org.example._20260729_springjparelationships.models.TeacherManyToMany;
import org.springframework.data.repository.CrudRepository;

public interface TeacherManyToManyRepository
        extends CrudRepository<TeacherManyToMany, Integer> {
}
