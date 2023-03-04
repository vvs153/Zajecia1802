package com.sda.zadanie1802.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateStudentResponse {
    private Long identifier;
    private String firstName;
    private String lastName;
    private Integer age;

}
