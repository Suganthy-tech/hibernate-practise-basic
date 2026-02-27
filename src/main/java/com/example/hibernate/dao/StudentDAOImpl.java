package com.example.hibernate.dao;

import com.example.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager em;
@Autowired
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }
@Transactional
    @Override
    public int save(Student student) {
         this.em.persist(student);
         return student.getId();
    }


    @Override
    public Student fetch(int id) {
    return this.em.find(Student.class,id);

    }

    @Override
    public List<Student> fetchAll() {
        TypedQuery<Student> myQuery= this.em.createQuery("From Student",Student.class);
        return myQuery.getResultList();

    }
    @Transactional
    @Override
    public List<Student> fetchCondiotionally(String lastName) {
        TypedQuery<Student> myQuery= this.em.createQuery("SELECT s From Student s WHERE s.lastName=:data",Student.class);
        myQuery.setParameter("data",lastName);
        return myQuery.getResultList();

    }
@Transactional
    @Override
    public void remove(int id) {
    Student s=this.em.find(Student.class,id);
    this.em.remove(s);

    }
@Transactional
    @Override
    public int updateDB(int id,String name) {
   Query query= this.em.createQuery("Update Student s set s.lastName='Agarwal' where s.lastName=:data");
//    TypedQuery<Student> query= this.em.createQuery("SELECT s FROM Student where s.lastname=:data ",Student.class);
    query.setParameter("data",name);

        return query.executeUpdate();
    }
}
