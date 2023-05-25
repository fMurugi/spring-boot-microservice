package com.fiona.school;

import com.fiona.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentClient studentClient;

    public SchoolService(SchoolRepository schoolRepository, StudentClient studentClient) {
        this.schoolRepository = schoolRepository;
        this.studentClient = studentClient;
    }

    public void createSchool(School school){
        schoolRepository.save(school);

    }
    public List<School> getAllSchools(){
        return  schoolRepository.findAll();
    }

    public SchoolResponse findSchoolsWithStudents(Integer schoolId) {
                var school = schoolRepository.findById(schoolId)
                        .orElse(
                                School.builder()
                                      .name("Not found")
                                      .email("NotFound")
                                      .build()

                        );
                var students = studentClient.findAllStudentsBySchool(schoolId);
                //find all students from students microservices;
        return  SchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }

}
