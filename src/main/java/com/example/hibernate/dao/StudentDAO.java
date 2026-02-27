package com.example.hibernate.dao;

import com.example.hibernate.entity.Student;

import java.util.List;

public interface StudentDAO {
    public int save(Student student);
    public Student fetch(int id);

    public void remove(int student);
    public List<Student> fetchAll();
    public List<Student> fetchCondiotionally(String lastname);
    public int updateDB(int a,String str);


}
