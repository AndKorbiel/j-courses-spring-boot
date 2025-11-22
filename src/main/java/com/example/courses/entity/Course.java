package com.example.courses.entity;

import com.example.staff.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  private int availableSeats;
  private String description;
  private int hoursPerWeek;
  private String name;
  private Long courseTeacherId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "courseParticipants_id", referencedColumnName = "id")
  public CourseParticipants courseParticipants;

  @ManyToOne
  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  @JsonBackReference
  public Teacher courseTeacher;

  public Course() {
  }

  public Course(
      String description,
      String name,
      Teacher courseTeacher,
      CourseParticipants courseParticipants,
      int hoursPerWeek) {
    this.description = description;
    this.name = name;
    this.courseParticipants = courseParticipants;
    this.courseTeacher = courseTeacher;
    this.hoursPerWeek = hoursPerWeek;
    this.courseTeacherId = courseTeacher.id;

    this.courseTeacher.addHours(Double.valueOf(hoursPerWeek));
  }

  public String getDescription() {
    return this.description;
  }

  public String getName() {
    return this.name;
  }

  public int getAvailableSeats() {
    return this.availableSeats;
  }

  public int getHoursPerWeek() {
    return this.hoursPerWeek;
  }

  public Long getCourseTeacherId() {
    return this.courseTeacherId;
  }
}
