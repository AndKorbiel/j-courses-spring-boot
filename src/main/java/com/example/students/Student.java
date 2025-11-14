package com.example.students;

import java.util.ArrayList;
import java.util.List;

import com.example.courses.Course;

public class Student {
  private static int studensCount = 0;
  private int id;
  public String name;
  private List<Course> coursesEnrolled = new ArrayList<>();

  public Student(String name) {
    this.name = name;
    studensCount++;
    this.id = studensCount;
  }

  public void enrollForCourse(Course newCourse) {
    this.coursesEnrolled.add(newCourse);
  }

  public int getId() {
    return this.id;
  }
}
