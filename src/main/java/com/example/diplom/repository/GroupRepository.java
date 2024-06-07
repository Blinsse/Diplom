package com.example.diplom.repository;

import com.example.diplom.models.Group;
import com.example.diplom.models.StreamsAutumn;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {
    Group findByGroupNameIsEndingWith(String name_group);
}
