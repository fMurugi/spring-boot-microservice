package com.fiona.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
