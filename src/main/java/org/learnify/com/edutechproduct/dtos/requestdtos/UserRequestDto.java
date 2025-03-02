package org.learnify.com.edutechproduct.dtos.requestdtos;


import lombok.Data;
import org.learnify.com.edutechproduct.models.Payment;
import org.learnify.com.edutechproduct.models.UserTypes;

@Data
public class UserRequestDto {
    private String name;
    private String phoneNumber;
    private String emailId;
    private String password;
    private UserTypes userTypes;
    private Payment payment;
}
