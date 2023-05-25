package com.fiona.school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    private  SchoolService schoolService;
    @PostMapping("/createSchool")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody School school){
        schoolService.createSchool(school);
    }

    @GetMapping("/getSchool")
    public ResponseEntity<List<School>> findAllStudents(){
        return ResponseEntity.ok(schoolService.getAllSchools()) ;
    }
    @GetMapping("/withStudents/{schoolId}")
    public  ResponseEntity<SchoolResponse> findAllSchools(@PathVariable Integer schoolId){
        return  ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));

    }

}
