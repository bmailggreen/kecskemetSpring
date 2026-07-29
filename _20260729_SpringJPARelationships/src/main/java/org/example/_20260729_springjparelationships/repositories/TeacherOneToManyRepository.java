package org.example._20260729_springjparelationships.repositories;

import org.example._20260729_springjparelationships.models.StudentOneToOne;
import org.example._20260729_springjparelationships.models.TeacherOneToMany;
import org.springframework.data.repository.CrudRepository;

public interface TeacherOneToManyRepository
        extends CrudRepository<TeacherOneToMany, Integer> {
}
