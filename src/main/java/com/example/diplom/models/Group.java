package com.example.diplom.models;

import jakarta.persistence.*;
import lombok.Data;
// academic_group
@Entity
@Table(name = "group_students")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "course")
    private int course;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "amount_students")
    private int amountStudents;
}
