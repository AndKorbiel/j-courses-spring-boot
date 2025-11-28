package com.example.students.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  public String name;

  private List<Long> enrolledCoursesIds = new ArrayList<>();

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public List<Long> getEnrolledCoursesList() {
    return this.enrolledCoursesIds;
  }

  public void enrollForCourse(Long courseId) {
    this.enrolledCoursesIds.add(courseId);
  }
}
