package com.sda.zadanie1802.controller;

import com.sda.zadanie1802.model.Student;
import com.sda.zadanie1802.model.dto.CreateStudentRequest;
import com.sda.zadanie1802.model.dto.UpdateStudentRequest;
import com.sda.zadanie1802.model.dto.UpdateStudentResponse;
import com.sda.zadanie1802.service.StudentService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    public  StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping()
    public List<Student> getStudentList(){
        log.info("ktos zapytal o liste studentow");
        return studentService.getAll();
    }
    @GetMapping("/byId")
    public Student getStudentWithId(@RequestParam Long studentId){
        log.info("ktos poprosil o wyswietlenie studenta o id: {}",studentId);
        return studentService.findById(studentId);
    }
    @GetMapping("/{identyfikator}")
    public Student getStudentById(@PathVariable Long identyfikator){
        log.info("ktos poprosil o wyswietlenie studenta o id: {}",identyfikator);
        return studentService.findById(identyfikator);
    }
    @DeleteMapping
    public void deleteStudent(@RequestParam Long id){
        log.info("ktos poprosil o usuniecie studenta o id: {}",id);
        studentService.delete(id);
    }
    @GetMapping("/birthyear")
    public int getBirthYear(@RequestParam Long sId){
        log.info("Ktos zapytal o rok urodzenia o id: {}",sId );
        return studentService.getBirthYearOfStudentWithId(sId);
    }

    @PostMapping
    public void createStudent(@RequestBody CreateStudentRequest request){
        log.info("Wywolano dodanie studenta: {}",request);
        studentService.createStudent(request);
    }
    @PatchMapping("/{studentId}")
    public UpdateStudentResponse updateStudent(@PathVariable Long studentId, @RequestBody UpdateStudentRequest request){
        log.info("ktos poprosil o zaaktualizowanie studenta o id: {}, dane: {}",studentId,request);
        return studentService.update(studentId,request);
    }
}
