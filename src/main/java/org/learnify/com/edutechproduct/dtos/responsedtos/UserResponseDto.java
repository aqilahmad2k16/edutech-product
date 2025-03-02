package org.learnify.com.edutechproduct.dtos.responsedtos;


import lombok.Data;
import org.learnify.com.edutechproduct.models.Payment;
import org.learnify.com.edutechproduct.models.UserTypes;

@Data
public class UserResponseDto {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private UserTypes userTypes;
    private Payment payment;
}
