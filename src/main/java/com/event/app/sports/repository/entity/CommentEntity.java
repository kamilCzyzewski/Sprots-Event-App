package com.event.app.sports.repository.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CommentEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserEntity creator;

    private String comment;

    @Column(updatable = false)
    private LocalDateTime dateOfCreation;

    @PrePersist
    protected void onCreate() {
        dateOfCreation = LocalDateTime.now();
    }

    public CommentEntity() {
    }

    public CommentEntity(UserEntity creator, String comment) {
        this.creator = creator;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", creator=" + creator +
                ", comment='" + comment + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }
}
