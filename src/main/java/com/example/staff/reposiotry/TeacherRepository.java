package com.example.staff.reposiotry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.staff.entity.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
  // List<Teacher> findBySalaryGreaterThan(double salary);
}
