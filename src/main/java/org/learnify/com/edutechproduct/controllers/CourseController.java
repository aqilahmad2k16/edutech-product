package com.course.courseservice.courseservice.controllers;

import com.course.courseservice.courseservice.dtos.requestdtos.CourseRequestDto;
import com.course.courseservice.courseservice.dtos.responsedtos.CourseDtoResponse;
import com.course.courseservice.courseservice.exceptions.customexception.CourseIsAlreadyExistException;
import com.course.courseservice.courseservice.models.Course;
import com.course.courseservice.courseservice.services.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    /*
    PostMapping("/course")
     */
    @PostMapping("/")
    public ResponseEntity<CourseDtoResponse> addNewCourse(@Valid @RequestBody CourseRequestDto courseRequestDto) throws CourseIsAlreadyExistException {
            Course savedCourse = courseService.addNewCourse(CourseRequestDto.to(courseRequestDto));
            CourseDtoResponse courseDtoResponse = CourseDtoResponse.from(savedCourse);
            return new ResponseEntity<>(courseDtoResponse, HttpStatus.CREATED);
    }

    /*
    GetMapping("/")
    //api to get list of course by category name
    //also apply index on category
    postMan request end-point: http://localhost:8086/api/v1/courses?categoryName=Programming
     */

    @GetMapping
    public ResponseEntity<List<CourseDtoResponse>> getAllCourses(@RequestParam(name = "categoryName") String category) {
        List<CourseDtoResponse> listCourseByName = courseService.getCoursesByCategory(category);
        return new ResponseEntity<>(listCourseByName, HttpStatus.OK);
    }

    /*
    @GetMapping
    creating api to get list course with a particular rating
     */

    @GetMapping("/{ratings}")
    public ResponseEntity<List<CourseDtoResponse>> getCourseByRatings(@PathVariable String ratings) {
        List<CourseDtoResponse> listCourseByRating = courseService.getCourseByRatings(ratings);
        return new ResponseEntity<>(listCourseByRating, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDtoResponse>> getAllCourse() {
        List<CourseDtoResponse> allCourses = courseService.getAllCourse();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

    /*
    GetMapping:- get all list of all courses whose rating is less than or equal to rating
    GET /api/courses/by-rating?maxRating=4.5
     */

    @GetMapping("/by-rating")
    public ResponseEntity<List<CourseDtoResponse>> getCourseByRating(@RequestParam String maxRating) {
        List<CourseDtoResponse> listCourseByRating  = courseService.getCourseByMaxRating(maxRating);
        return new ResponseEntity<>(listCourseByRating, HttpStatus.OK);
    }
}
