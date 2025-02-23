package com.satyam.bcibackend.userentity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String otp;
    private String phoneNumber;
    private String fullName;
    private String emailAddress;
    private LocalDate dateOfBirth;
    private String gender;
    private LocalDateTime otpExpiryDateTime;
}
