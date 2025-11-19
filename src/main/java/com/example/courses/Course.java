package com.example.courses;

import com.example.staff.Teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Course {
  private String description;
  private int hoursPerWeek;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int id;
  private String name;
  public CourseParticipants courseParticipants;
  public Teacher courseTeacher;
  private static int coursesCount = 0;

  public Course(
      String description,
      String name,
      Teacher courseTeacher,
      int availableSeats,
      int hoursPerWeek) {
    this.description = description;
    this.name = name;
    this.courseParticipants = new CourseParticipants(availableSeats);
    this.courseTeacher = courseTeacher;
    this.hoursPerWeek = hoursPerWeek;

    this.courseTeacher.addHours(Double.valueOf(hoursPerWeek));

    coursesCount++;
    this.id = coursesCount;
  }

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }

  public int getHoursPerWeek() {
    return this.hoursPerWeek;
  }
}
