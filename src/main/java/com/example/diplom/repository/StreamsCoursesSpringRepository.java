package com.example.diplom.repository;

import com.example.diplom.models.StreamsCoursesSpring;
import org.springframework.data.repository.CrudRepository;

public interface StreamsCoursesSpringRepository extends CrudRepository<StreamsCoursesSpring, Long> {
    StreamsCoursesSpring findByCourseName(String course_name);
}
