package com.fiona.school;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SchoolResponse {
    private String name;
    private String email;
    private List<Student> students;
}
