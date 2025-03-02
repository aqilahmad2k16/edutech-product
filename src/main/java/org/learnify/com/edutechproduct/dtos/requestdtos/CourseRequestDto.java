package com.course.courseservice.courseservice.dtos.requestdtos;

import com.course.courseservice.courseservice.models.Category;
import com.course.courseservice.courseservice.models.Course;
import com.course.courseservice.courseservice.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseRequestDto {
    @NotBlank(message = "Course name can not be empty")
    @Size(max = 100, message = "Course name can not be exceed 100 characters")
    private String name;
    @NotBlank(message = "author name can not be empty! It must be some value")
    private String author;
    private String ratings;
    private String description;
    private String totalDuration;
    private Double progress;
    private Boolean isComplete;
    private Long sessionsCompleted;
    private Long totalSessions;
    private String nextSessionDate;
    private User mentor;
    private Category category;
    public static Course to(CourseRequestDto courseRequestDto) {
        Course course = new Course();
        course.setName(courseRequestDto.getName());
        course.setAuthor(courseRequestDto.getAuthor());
        course.setRatings(courseRequestDto.getRatings());
        course.setDescription(courseRequestDto.getDescription());
        course.setTotalDuration(courseRequestDto.getTotalDuration());
        course.setProgress(courseRequestDto.getProgress());
        course.setTotalSessions(courseRequestDto.getTotalSessions());
        User mentor = new User();
        mentor.setName(courseRequestDto.getMentor().getName());
        course.setMentor(mentor);
        Category category = new Category();
        category.setName(courseRequestDto.getCategory().getName());
        course.setCategory(category);
        course.setSessionsCompleted(courseRequestDto.getSessionsCompleted());
        course.setIsComplete(courseRequestDto.getIsComplete());
        course.setNextSessionDate(courseRequestDto.getNextSessionDate());
        return course;
    }
}
