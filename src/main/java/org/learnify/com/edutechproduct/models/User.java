package com.course.courseservice.courseservice.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class User extends BaseModel{
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserTypes userTypes;
    private String profileImage;
    private String membershipLevel;
    private Long totalCourseEnrolled;
//    @OneToOne(mappedBy = "user")
////    private Payment payment;
    private Boolean isEmailVerified;
    @ManyToMany
    @JoinTable(
            name = "user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @BatchSize(size = 10)
    private Set<Course> courses = new HashSet<>();
}
