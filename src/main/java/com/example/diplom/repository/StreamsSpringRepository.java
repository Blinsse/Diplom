package com.example.diplom.repository;

import com.example.diplom.models.StreamsSpring;
import org.springframework.data.repository.CrudRepository;

public interface StreamsSpringRepository extends CrudRepository<StreamsSpring, Long> {
    StreamsSpring findByNameStream(String name_stream);
}
