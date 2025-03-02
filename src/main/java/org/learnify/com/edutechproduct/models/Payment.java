package com.course.courseservice.courseservice.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment extends BaseModel{
    private String referenceNumber;
    private PaymentStatus paymentStatus;
    private PaymentTypes paymentTypes;
    private String paymentReciept;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
