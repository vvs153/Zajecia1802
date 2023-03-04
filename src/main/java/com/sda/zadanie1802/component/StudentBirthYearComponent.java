package com.sda.zadanie1802.component;

import com.sda.zadanie1802.exception.IllegalValueException;
import com.sda.zadanie1802.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class StudentBirthYearComponent {
    public int calculateBirthYear(Student student){
        if (student.getWiek()==null){
            throw new IllegalValueException("wiek jest nulle");
        }
        int year = LocalDate.now().getYear();
        return year - student.getWiek();
    }
}
