package com.example.diplom.repository;

import com.example.diplom.models.StreamsCoursesAutumn;
import org.springframework.data.repository.CrudRepository;

public interface StreamsCoursesAutumnRepository extends CrudRepository<StreamsCoursesAutumn, Long> {
    StreamsCoursesAutumn findByCourseName(String course_name);
}
