package com.course.courseservice.courseservice.repositories;

import com.course.courseservice.courseservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByNameAndCategoryName(String name, String name1);

    List<Course> findByCategoryName(String category);

    List<Course> findByRatingsGreaterThanEqual(String ratings);

    List<Course> findByRatingsLessThanEqual(String maxRating);
}
