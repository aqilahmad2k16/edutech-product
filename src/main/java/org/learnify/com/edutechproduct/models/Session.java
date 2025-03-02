package com.course.courseservice.courseservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Session extends BaseModel{
    private String name;
    private String description;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "module_id")
//    private Module module;
    private String mediaSrc;
    private String notesSrc;
    private String assignmentSrc;
    private String durationOfSession;
}
