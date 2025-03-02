package com.course.courseservice.courseservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "Likes")
@Data
public class Like extends BaseModel{
    private Integer likes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
