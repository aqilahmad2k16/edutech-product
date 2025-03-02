package com.course.courseservice.courseservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment extends BaseModel {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Course course;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private User user;

    private Boolean isActive;
    private Double progress;
}
