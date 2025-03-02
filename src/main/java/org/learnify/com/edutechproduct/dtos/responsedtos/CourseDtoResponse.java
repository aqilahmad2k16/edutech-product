package com.course.courseservice.courseservice.dtos.responsedtos;

import com.course.courseservice.courseservice.models.Category;
import com.course.courseservice.courseservice.models.Course;
import com.course.courseservice.courseservice.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDtoResponse {
    private String courseId;
    private String mentorId;
    private String categoryId;
    public static CourseDtoResponse from(Course savedCourse) {
        CourseDtoResponse response = new CourseDtoResponse();
        response.setCourseId("course_" + savedCourse.getId());
        response.setMentorId("courseMentor_" + savedCourse.getId());
        response.setCategoryId("courseCategory_" + savedCourse.getCategory().getId());
        return response;
    }

    public static List<CourseDtoResponse> getListFrom(List<Course> courses) {
        List<CourseDtoResponse> responses = new ArrayList<>();
        courses.forEach(course -> {
           responses.add(CourseDtoResponse.from(course));
        });

        return responses;
    }
}
