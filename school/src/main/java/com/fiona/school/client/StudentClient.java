package com.fiona.school.client;

import com.fiona.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="StudentService",url="${application.config.students-url}")
public interface StudentClient {
    @GetMapping("school/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable Integer schoolId);



}
