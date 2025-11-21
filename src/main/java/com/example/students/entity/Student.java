package com.example.students.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.courses.Course;

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
  // private List<Course> coursesEnrolled = new ArrayList<>();

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  // public void enrollForCourse(Course newCourse) {
  // this.coursesEnrolled.add(newCourse);
  // }

  public Long getId() {
    return this.id;
  }
}
