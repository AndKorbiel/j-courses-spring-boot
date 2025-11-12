package com.example.courses;

import com.example.staff.Teacher;

public class Course {
  private String description;
  private int hoursPerWeek;
  private String name;
  public CourseParticipants courseParticipants;
  public Teacher courseTeacher;

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
