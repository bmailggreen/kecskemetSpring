package org.example._20260729_springjparelationships.repositories;

import org.example._20260729_springjparelationships.models.StudentOneToMany;
import org.example._20260729_springjparelationships.models.StudentOneToOne;
import org.springframework.data.repository.CrudRepository;

public interface StudentOneToManyRepository
        extends CrudRepository<StudentOneToMany, Integer> {
}
