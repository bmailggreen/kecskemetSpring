package org.example._20260729_springjparelationships.repositories;

import org.example._20260729_springjparelationships.models.TeacherOneToOne;
import org.springframework.data.repository.CrudRepository;

public interface TeacherOneToOneRepository
        extends CrudRepository<TeacherOneToOne, Integer> {
}
