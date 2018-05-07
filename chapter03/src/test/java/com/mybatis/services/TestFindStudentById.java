package com.mybatis.services;

import com.mybatis3.domain.Student;
import com.mybatis3.mappers.StudentMapper;
import com.mybatis3.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class TestFindStudentById {

    /*  public static Student findStudentById(){
          SqlSession sqlSession = MyBatisUtil.getSqlSession();
          try {
              Student student = sqlSession.selectOne("com.mybatis3.mappers.StudentMapper.findStudentById", 1);
              return student;
          }finally {
              sqlSession.close();
          }
      }*/
    public static Student findStudentById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.findStudentById(1);
        } finally {
            sqlSession.close();
        }
    }

    public static Integer insertStudent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            Student student = new Student();
            student.setName("student_" + 4);
            student.setEmail("student_4@gmail.com");
            int count = sqlSession.insert("com.mybatis3.mappers.StudentMapper.insertStudent",student);
            System.out.println("id : " + student.getStudId());
            sqlSession.commit();
            return count;
        } finally {
            sqlSession.close();
        }
    }

    /*public static Integer insertStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            Student student = new Student();
            int id = 6;
            student.setName("student_" + id);
            student.setEmail("student_" + id + "@gmail.com");
//           int count = sqlSession.insert("com.mybatis3.mappers.StudentMapper.insertStudent",student);
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Integer count = mapper.insertStudent(student);
            sqlSession.commit();
            System.out.println("id = " + student.getStudId());
            return count;
        } finally {
            sqlSession.close();
        }
    }*/

    public static void main(String[] args) {
//        System.out.println(findStudentById());
        System.out.println(insertStudent());
    }
}
