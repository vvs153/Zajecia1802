package com.sda.zadanie1802.model.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//DTO - data transfer object - obiekt ktorego uzywamy do komunikacji [klient <-> aplikacja]
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private Integer age;
}
