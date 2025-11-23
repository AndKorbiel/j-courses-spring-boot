package com.example.courses.entity;

import com.example.staff.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  private int availableSeats;
  private String description;
  private int hoursPerWeek;
  private String name;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "courseParticipants_id", referencedColumnName = "id")
  public CourseParticipants courseParticipants;

  @ManyToOne
  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  public Teacher courseTeacher;

  public Course() {
  }

  public Course(
      String description,
      String name,
      int availableSeats,
      int hoursPerWeek,
      Teacher courseTeacher,
      CourseParticipants courseParticipants) {
    this.description = description;
    this.name = name;
    this.availableSeats = availableSeats;
    this.hoursPerWeek = hoursPerWeek;
    this.courseParticipants = courseParticipants;
    this.courseTeacher = courseTeacher;

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
}
