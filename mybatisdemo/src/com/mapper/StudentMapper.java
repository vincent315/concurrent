package com.mapper;

import com.pojo.Students;

import java.util.List;

public interface StudentMapper {
    //查询所有学生
    public List<Students> findAllStudents();
    //据据id找学生
    //public Students findStudentById(Integer id);

    //增加一个学生
    public void insertStudent(Students student);
}
