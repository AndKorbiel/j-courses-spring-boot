package com.example.courses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.shared.Skills;
import com.example.students.entity.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class CourseParticipants {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  private int availableSeats;

  @OneToMany(mappedBy = "coursesEnrolled", cascade = CascadeType.ALL)
  private Map<Long, Student> registeredStudentsList = new HashMap<>();

  // @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  // private List<Student> waitingStudentsList = new LinkedList<>();

  public CourseParticipants(int availableSeats) {
    this.availableSeats = availableSeats;
  }

  public Map<Long, Student> getRegisteredStudentsListList() {
    return this.registeredStudentsList;
  }

  public boolean checkIfCourseIsFull() {
    return this.availableSeats == 0;
  }

  public void enrollStudent(Student newStudent) {
    if (!this.checkIfCourseIsFull()) {
      Long studentId = newStudent.getId();

      this.registeredStudentsList.put(studentId, newStudent);
      this.availableSeats--;
    } else {
      // this.waitingStudentsList.add(newStudent);
    }
  }

  public void removeStudent(Student currentStudent) {
    Long studentId = currentStudent.getId();

    this.registeredStudentsList.remove(studentId);

    // if (!this.waitingStudentsList.isEmpty()) {
    // Student studentFromQueue = this.waitingStudentsList.getFirst();

    // this.enrollStudent(studentFromQueue);
    // this.waitingStudentsList.removeFirst();
    // } else {
    // this.availableSeats++;
    // }
  }

  public int getAvailableSeats() {
    return this.availableSeats;
  }
}
