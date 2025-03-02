package com.course.courseservice.courseservice.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {@Index(name = "idx_category_id", columnList = "category_id"),
        @Index(name = "idx_ratings", columnList = "ratings")})
public class Course extends BaseModel{
    private String name;
    @Column(nullable = false, columnDefinition = "String default 3.0")
    private String ratings;
    private String description;
    private String author;
    private String totalDuration;
    private Double progress;
    private Boolean isComplete;
    private Long sessionsCompleted;
    private Long totalSessions;
    private String nextSessionDate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private User mentor;

    //this is owning table, which has foreign key

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Module> modules;

    /*
    course <=> mentor
       1 => 1
       M => 1
       M : 1
     */

}
