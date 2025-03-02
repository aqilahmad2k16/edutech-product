package com.course.courseservice.courseservice.services.services;

import com.course.courseservice.courseservice.dtos.responsedtos.CourseDtoResponse;
import com.course.courseservice.courseservice.exceptions.customexception.CourseIsAlreadyExistException;
import com.course.courseservice.courseservice.models.Course;

import java.util.List;

public interface CourseService {
    Course addNewCourse(Course course) throws CourseIsAlreadyExistException;

    List<CourseDtoResponse> getCoursesByCategory(String category);

    List<CourseDtoResponse> getCourseByRatings(String ratings);
    List<CourseDtoResponse> getAllCourse();

    List<CourseDtoResponse> getCourseByMaxRating(String maxRating);
}
