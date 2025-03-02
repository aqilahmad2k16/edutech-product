package com.course.courseservice.courseservice.exceptions;

import com.course.courseservice.courseservice.dtos.responsedtos.ExceptionResponseDto;
import com.course.courseservice.courseservice.exceptions.customexception.CourseIsAlreadyExistException;
import com.course.courseservice.courseservice.exceptions.customexception.CourseNotFoundException;
import com.course.courseservice.courseservice.exceptions.customexception.ModuleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class globalexception {
    @ExceptionHandler(CourseIsAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDto> handleCourseIsAlreadyExistException(CourseIsAlreadyExistException e, WebRequest request){
        ExceptionResponseDto response = new ExceptionResponseDto(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                request.getContextPath()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleCourseNotFoundException(CourseNotFoundException e, WebRequest request){
        ExceptionResponseDto responseDto = new ExceptionResponseDto(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                request.getContextPath()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModuleNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleModuleNotFoundException(ModuleNotFoundException e, WebRequest request){
        ExceptionResponseDto response = new ExceptionResponseDto(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                request.getContextPath()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request){
        ExceptionResponseDto responseDto = new ExceptionResponseDto(
          e.getMessage(),
          HttpStatus.BAD_REQUEST,
          request.getContextPath()
        );

        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
