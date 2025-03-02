package com.course.courseservice.courseservice.dtos.requestdtos;

import com.course.courseservice.courseservice.models.Payment;
import com.course.courseservice.courseservice.models.UserTypes;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String phoneNumber;
    private String emailId;
    private String password;
    private UserTypes userTypes;
    private Payment payment;
}
