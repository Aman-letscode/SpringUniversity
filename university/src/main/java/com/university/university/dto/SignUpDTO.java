package com.university.university.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpDTO {
    private String name;
    private String email;
    private String password;
    private String role;
    private String phonenumber;
}
