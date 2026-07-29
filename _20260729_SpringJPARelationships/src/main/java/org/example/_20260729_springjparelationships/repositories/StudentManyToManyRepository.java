package org.example._20260729_springjparelationships.repositories;

import org.example._20260729_springjparelationships.models.StudentManyToMany;
import org.springframework.data.repository.CrudRepository;

public interface StudentManyToManyRepository
        extends CrudRepository<StudentManyToMany, Integer> {
}
