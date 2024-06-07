package com.example.diplom.repository;

import com.example.diplom.models.StreamsAutumn;
import com.example.diplom.models.StreamsCoursesAutumn;
import org.springframework.data.repository.CrudRepository;

public interface StreamsAutumnRepository extends CrudRepository<StreamsAutumn, Long> {
    StreamsAutumn findByNameStream(String name_stream);
}
