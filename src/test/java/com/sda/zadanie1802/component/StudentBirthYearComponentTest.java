package com.sda.zadanie1802.component;

import com.sda.zadanie1802.exception.IllegalValueException;
import com.sda.zadanie1802.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentBirthYearComponentTest {
private final StudentBirthYearComponent birthYearComponent = new StudentBirthYearComponent();
    @Test
    @DisplayName("Oblicza poprawnie rok urodzenia jesli student posiada wartosc pola wiek")
    void testBirthYearCalculation(){
        //Given
        final var student = new Student(null,null,null,25);
        //Then
        final var wynik = birthYearComponent.calculateBirthYear(student);

        //Assert
        assertEquals(LocalDate.now().getYear()-25,wynik);
    }
    @Test
    @DisplayName("Wyrzuca invalidargument exception jesli weiek nie ma wartosci")
    void testBirthYearCalculationThrowsException(){
        //Given
        final var student = new Student(null,null,null,null);
        //Then assert
        assertThrows(IllegalValueException.class, () -> {
            birthYearComponent.calculateBirthYear(student);
        });


    }
}