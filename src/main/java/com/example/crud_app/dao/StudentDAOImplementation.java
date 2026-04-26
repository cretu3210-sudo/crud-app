package com.example.crud_app.dao;

import com.example.crud_app.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class StudentDAOImplementation implements StudentDAO{
    //Cimp pentru EntityManager (va fi utilizat pentru interactiunea cu baza de date)
    private EntityManager entityManager;

    //Injectare EntityManager prin constructor (practica recomandata pentru testabilitate si modularitate)
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //Implementarea metodei save pentru salvarea unui obiect Student in baza de date
    @Override
    @Transactional
    public void save (Student theStudent){
        entityManager.persist(theStudent);

    }

    @Override
    public Student findbyId(Integer id) {
        return entityManager.find(Student.class, id);
    }
    @Override
    public List<Student> findAll(){
        //creare query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //returnam query results
        return theQuery.getResultList();
    }
}
