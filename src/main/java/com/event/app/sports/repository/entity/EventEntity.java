package com.event.app.sports.repository.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class EventEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private UserEntity creator;

    private Integer maxNumberOfParticipants;

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

    @ManyToOne
    private AddressEntity address;

    @OneToMany
    private List<UserEntity> participants;

    @OneToMany(orphanRemoval = true)
    private List<CommentEntity> comments;

    @Column(updatable = false)
    private LocalDateTime dateOfCreation;
}
