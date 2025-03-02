package org.learnify.com.edutechproduct.services.services;

import org.learnify.com.edutechproduct.dtos.responsedtos.CourseDtoResponse;
import org.learnify.com.edutechproduct.exceptions.customexception.CourseIsAlreadyExistException;
import org.learnify.com.edutechproduct.models.Course;

import java.util.List;

public interface CourseService {
    Course addNewCourse(Course course) throws CourseIsAlreadyExistException;

    List<CourseDtoResponse> getCoursesByCategory(String category);

    List<CourseDtoResponse> getCourseByRatings(String ratings);
    List<CourseDtoResponse> getAllCourse();

    List<CourseDtoResponse> getCourseByMaxRating(String maxRating);
}
