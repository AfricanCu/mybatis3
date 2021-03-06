package com.mybatis3.services;

import com.mybatis3.domain.Student;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class StudentServiceTest {
    private static StudentService studentService;
    @BeforeClass
    public static void setup(){
        studentService = new StudentService();
    }
    @AfterClass
    public static void teardown(){
        studentService = null;
    }
    @Test
    public void testFindAllStudents(){
        List<Student> students = studentService.findAllStudents();
        Assert.assertNotNull(students);
        for (Student student : students){
            System.out.println(student);
        }
    }

    @Test
    public void testFindStudentById(){
        Student student = studentService.findStudentById(1);
        Assert.assertNotNull(student);
        System.out.println(student);
    }

    @Test
    public void testCreateStudent(){
        Student student = new Student();
        int id = 3;
        student.setStudId(id);
        student.setName("student_"+id);
        student.setEmail("student_" + id + "gmail.com");
        student.setDob(new Date());
        studentService.createStudent(student);
        Student newStudent = studentService.findStudentById(3);
        Assert.assertNotNull(newStudent);
    }
}