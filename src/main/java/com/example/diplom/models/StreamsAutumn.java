package com.example.diplom.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.List;

import java.util.Set;


@Entity
@Table(name = "educational_streams")
@Data
public class StreamsAutumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name_stream")
    private String nameStream;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "streams_courses",
            joinColumns =
                    { @JoinColumn(name = "stream_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "course_id", referencedColumnName = "id") })
    private Set<StreamsCoursesAutumn> streamsCoursesAutumns;
    @Column(name = "name_groups")
    private String nameGroups;
}