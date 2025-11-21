package com.example.students.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.students.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
