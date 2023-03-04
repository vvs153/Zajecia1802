package com.sda.zadanie1802.service;

import com.sda.zadanie1802.component.StudentBirthYearComponent;
import com.sda.zadanie1802.model.Student;
import com.sda.zadanie1802.model.dto.CreateStudentRequest;
import com.sda.zadanie1802.model.dto.UpdateStudentRequest;
import com.sda.zadanie1802.model.dto.UpdateStudentResponse;
import com.sda.zadanie1802.repository.StudentDao;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {
    private StudentDao studentDao;
    private StudentBirthYearComponent birthYearComponent;

    public StudentService(StudentDao studentDao, StudentBirthYearComponent birthYearComponent) {
        this.studentDao = studentDao;
        this.birthYearComponent = birthYearComponent;
    }

    public List<Student> getAll(){
        return studentDao.findAll();

    }
    public void delete(Long studentId){
        studentDao.deleteById(studentId);
    }
    public int getBirthYearOfStudentWithId(Long studentId){
       Student student =  studentDao.findById(studentId).orElseThrow(()-> new EntityNotFoundException("nie znalezino"));
        return birthYearComponent.calculateBirthYear(student);
       // Optional<Student> studentOptional = studentDao.findById(studentId);
       // if (studentOptional.isPresent()){
         //   Student student = studentOptional.get();
           // return birthYearComponent.calculateBirthYear(student);
       // }
        //throw new EntityNotFoundException("Nie znaleziono studenta o id "+ studentId);
    }

    public Student findById(Long studentId) {
        return studentDao.findById(studentId).orElseThrow(()-> new EntityNotFoundException("nie znalezino"));

    }

    public void createStudent(CreateStudentRequest request) {
        //Student student = new Student(null, request.getFirstName(), request.getLastName(), request.getAge());
        Student student = Student.builder().imie(request.getFirstName()).nazwisko(request.getLastName()).wiek(request.getAge()).build();
        studentDao.save(student);
    }

    public UpdateStudentResponse update(Long studentId, UpdateStudentRequest request) {
       Student student =  studentDao.findById(studentId).orElseThrow(()-> new EntityNotFoundException("nie znalezino"));
       if(request.getFirstName() != null){
           student.setImie(request.getFirstName());
       }
     //  if(request.getLastName() !=null){
     //   student.setNazwisko(request.getLastName);
      // }
      // if(request.getAge()!=null){
        //   student.setWiek(request.getAge);
      // } ----bylo by tak gdybysmy pozwalali na edycje wszystkeigo
        student = studentDao.save(student); // zapisz zaaktualizowany obiekt, metoda save zwraca obiekt po aktualzicji

        //zwroc response, nie studenta(nie entity)
        return studentToStudentResponse(student);
    }
    private UpdateStudentResponse studentToStudentResponse(Student student) {
        return new UpdateStudentResponse(
                student.getId(),
                student.getImie(),
                student.getNazwisko(),
                student.getWiek()
        );
    }
}
