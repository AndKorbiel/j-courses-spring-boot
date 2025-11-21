package com.example.courses.entity;

import com.example.courses.CourseParticipants;
import com.example.staff.entity.Teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  private String description;
  private int hoursPerWeek;
  private String name;
  // public CourseParticipants courseParticipants;

  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "teacher_id")
  // public Teacher courseTeacher;

  public Course() {

  }

  public Course(
      String description,
      String name,
      Teacher courseTeacher,
      int availableSeats,
      int hoursPerWeek) {
    this.description = description;
    this.name = name;
    // this.courseParticipants = new CourseParticipants(availableSeats);
    // this.courseTeacher = courseTeacher;
    this.hoursPerWeek = hoursPerWeek;

    // this.courseTeacher.addHours(Double.valueOf(hoursPerWeek));
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
