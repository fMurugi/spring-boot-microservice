package com.fiona.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.findALlStudent()) ;
    }

    @GetMapping("school/{schoolId}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable Integer schoolId){
        return ResponseEntity.ok(studentService.findALlStudentsBySchoolId(schoolId));

    }

}
