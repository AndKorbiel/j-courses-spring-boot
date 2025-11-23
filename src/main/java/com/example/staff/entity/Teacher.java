package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.courses.entity.Course;
import com.example.shared.Skills;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  public String name;
  private double hoursPerWeek;
  private double salaryPerHour;

  @ElementCollection(targetClass = Skills.class)
  @CollectionTable
  @Enumerated(EnumType.STRING)
  private List<Skills> skills = new ArrayList<>();

  @OneToMany(mappedBy = "courseTeacher", cascade = CascadeType.ALL)
  public List<Course> assignedCourses;

  public Teacher() {
  }

  public Teacher(String name, double salaryPerHour, List<Skills> skills) {
    this.name = name;
    this.salaryPerHour = salaryPerHour;
    this.skills = skills;
  }

  public List<Course> getAssignedCourses() {
    return this.assignedCourses;
  }

  public double getSalary() {
    return this.salaryPerHour;
  }

  public double getHoursPerWeek() {
    return this.hoursPerWeek;
  }

  public List<Skills> getSkills() {
    return this.skills;
  }

  public void addHours(Double hoursToAdd) {
    this.hoursPerWeek += hoursToAdd;
  }

  public void addCourse(Course newCourse) {
    this.assignedCourses.add(newCourse);
  }

  public Double countMonthlySalary() {
    return hoursPerWeek * 4 * salaryPerHour;
  }
}
