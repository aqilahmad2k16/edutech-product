package com.course.courseservice.courseservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Post extends BaseModel{
    private String text;
    private String mediaContentSrc;
//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Like> likes;

}
