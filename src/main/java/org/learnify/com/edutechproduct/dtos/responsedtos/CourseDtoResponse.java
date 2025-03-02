package org.learnify.com.edutechproduct.dtos.responsedtos;
import lombok.Data;
import org.learnify.com.edutechproduct.models.Course;

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
