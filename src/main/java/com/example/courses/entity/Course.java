package com.example.courses.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.staff.entity.Teacher;
import com.example.students.entity.Student;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

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

  @ManyToOne
  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  public Teacher courseTeacher;

  @ManyToMany
  private List<Student> courseStudents;

  public Course() {
  }

  public Course(
      String description,
      String name,
      int availableSeats,
      int hoursPerWeek,
      Teacher courseTeacher) {
    this.description = description;
    this.name = name;
    this.availableSeats = availableSeats;
    this.hoursPerWeek = hoursPerWeek;
    this.courseTeacher = courseTeacher;
    this.courseStudents = new ArrayList<>();

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

  public List<Student> getCourseStudentsList() {
    return this.courseStudents;
  }

  public void enrollStudent(Student student) {
    this.courseStudents.add(student);
    this.availableSeats--;
  }
}
