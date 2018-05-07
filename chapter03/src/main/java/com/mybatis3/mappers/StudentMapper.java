package com.mybatis3.mappers;

import com.mybatis3.domain.Student;

public interface StudentMapper {
    Student findStudentById(Integer id);
    Integer insertStudent(Student student);
}
