package com.fiona.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private  final StudentsRepository studentsRepository;

    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public  void saveStudent(Student student){
        studentsRepository.save(student);

    }
    public List<Student> findALlStudent(){
       return studentsRepository.findAll();
    }


    public List<Student> findALlStudentsBySchoolId(Integer schoolId) {
       return studentsRepository.findAllBySchoolId(schoolId);
    }
}
