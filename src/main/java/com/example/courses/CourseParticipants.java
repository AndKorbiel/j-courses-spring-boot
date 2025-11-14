package com.example.courses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.example.students.Student;

public class CourseParticipants {
  private int availableSeats;
  private Map<Integer, Student> registeredStudentsList = new HashMap<>();
  private List<Student> waitingStudentsList = new LinkedList<>();

  public CourseParticipants(int availableSeats) {
    this.availableSeats = availableSeats;
  }

  public Map<Integer, Student> getRegisteredStudentsListList() {
    return this.registeredStudentsList;
  }

  public boolean checkIfCourseIsFull() {
    return this.availableSeats == 0;
  }

  public void enrollStudent(Student newStudent) {
    if (!this.checkIfCourseIsFull()) {
      int studentId = newStudent.getId();

      this.registeredStudentsList.put(studentId, newStudent);
      this.availableSeats--;
    } else {
      this.waitingStudentsList.add(newStudent);
    }
  }

  public void removeStudent(Student currentStudent) {
    int studentId = currentStudent.getId();

    this.registeredStudentsList.remove(studentId);

    if (!this.waitingStudentsList.isEmpty()) {
      Student studentFromQueue = this.waitingStudentsList.getFirst();

      this.enrollStudent(studentFromQueue);
      this.waitingStudentsList.removeFirst();
    } else {
      this.availableSeats++;
    }
  }

  public int getAvailableSeats() {
    return this.availableSeats;
  }
}
