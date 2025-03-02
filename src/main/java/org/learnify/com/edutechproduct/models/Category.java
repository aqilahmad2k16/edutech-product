package com.course.courseservice.courseservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(indexes = {@Index(name = "idx_category_name", columnList = "name")})
public class Category extends BaseModel{
    @NotBlank
    private String name;
    //inverse table which will have mapped objects belong to one category in course table
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Course> courses;

    public Category(String name){
        this.name = name;
    }
    //explicitly add default constructor
    public Category() {

    }

}
