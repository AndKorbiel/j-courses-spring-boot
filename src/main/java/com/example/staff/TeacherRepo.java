package com.example.staff;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Long> {
  List<Teacher> findBySalaryGreaterThan(double salary);
}
