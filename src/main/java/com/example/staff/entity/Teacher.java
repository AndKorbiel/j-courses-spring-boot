package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;
import com.example.shared.Skills;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  public String name;
  private double hoursPerWeek;
  private double salary;

  @ElementCollection(targetClass = Skills.class)
  @CollectionTable
  @Enumerated(EnumType.STRING)
  private List<Skills> skills = new ArrayList<>();

  public Teacher() {
  }

  public Teacher(String name, double salary, List<Skills> skills) {
    this.name = name;
    this.salary = salary;
    this.skills = skills;
  }

  public double getSalary() {
    return this.salary;
  }

  public List<Skills> getSkills() {
    return this.skills;
  }

  public void addHours(Double hoursToAdd) {
    this.hoursPerWeek += hoursToAdd;
  }

  public Double countMonthlySalary() {
    return hoursPerWeek * 4 * salary;
  }
}
