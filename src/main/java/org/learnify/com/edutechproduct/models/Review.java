package com.course.courseservice.courseservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Review extends BaseModel{
    private String comments;
//    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Like> likes;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id")
    private Course course;
}
