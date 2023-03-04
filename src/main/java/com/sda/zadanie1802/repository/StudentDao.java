package com.sda.zadanie1802.repository;

import com.sda.zadanie1802.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//CRUD
public interface StudentDao extends JpaRepository<Student, Long> {
}
