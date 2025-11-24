package com.example.students.entity;

import java.util.List;

import com.example.courses.entity.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  public String name;

  @ManyToMany(mappedBy = "courseStudents")
  private List<Course> coursesEnrolled;

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public List<Course> getEnrolledCoursesList() {
    return this.coursesEnrolled;
  }
}
