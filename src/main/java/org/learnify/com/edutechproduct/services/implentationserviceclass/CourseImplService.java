package com.course.courseservice.courseservice.services.implentationserviceclass;

import com.course.courseservice.courseservice.dtos.responsedtos.CourseDtoResponse;
import com.course.courseservice.courseservice.exceptions.ExceptionMessage;
import com.course.courseservice.courseservice.exceptions.customexception.CourseIsAlreadyExistException;
import com.course.courseservice.courseservice.exceptions.customexception.CourseNotFoundException;
import com.course.courseservice.courseservice.models.Course;
import com.course.courseservice.courseservice.repositories.CourseRepository;
import com.course.courseservice.courseservice.services.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseImplService implements CourseService {
    @Autowired
    private CourseRepository courseRepo;
    @Override
    public Course addNewCourse(Course course) throws CourseIsAlreadyExistException {
        Optional<Course> optionalCourse = courseRepo.findByNameAndCategoryName(
                course.getName(),
                course.getCategory().getName()
        );
        Course savedCourse;
        if(optionalCourse.isEmpty()){
            //return exception course is already exist
            savedCourse = courseRepo.save(course);
        } else {
            throw new CourseIsAlreadyExistException("Course is already exist");
        }

        return savedCourse;
    }

    @Override
    public List<CourseDtoResponse> getCoursesByCategory(String category) {
        List<Course> courses = courseRepo.findByCategoryName(category);
        return CourseDtoResponse.getListFrom(courses);
    }

    @Override
    public List<CourseDtoResponse> getCourseByRatings(String ratings) {
        List<Course> course = courseRepo.findByRatingsGreaterThanEqual(ratings);
        return course.stream()
                .map(CourseDtoResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDtoResponse> getAllCourse() {
        List<Course> courses = courseRepo.findAll();
        return courses.stream()
                .map(CourseDtoResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDtoResponse> getCourseByMaxRating(String maxRating) {
        List<Course> courses = courseRepo.findByRatingsLessThanEqual(maxRating);
        if(courses.isEmpty()){
            throw new CourseNotFoundException(ExceptionMessage.NO_COURSE_IS_FOUND);
        }
        return courses.stream()
                .map(CourseDtoResponse::from)
                .collect(Collectors.toList());
    }
}
