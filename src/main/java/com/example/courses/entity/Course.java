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
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  private String description;
  private int hoursPerWeek;
  private String name;

  @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  public CourseParticipants courseParticipants;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  @JsonBackReference
  public Teacher courseTeacher;

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
    this.courseParticipants = new CourseParticipants(11);
    this.courseTeacher = courseTeacher;
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
