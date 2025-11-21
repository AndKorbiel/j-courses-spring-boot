package com.example.courses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.example.courses.entity.CourseParticipants;
import com.example.students.entity.Student;

public class CourseParticipantsTest {
  // given
  private final CourseParticipants courseParticipatns = new CourseParticipants();
  private final Student studentA = new Student("John");
  private final Student studentB = new Student("Peter");

  // @Test
  // public void testEnrollStudents() {
  // // given
  // final Map<Long, Student> enrolledStudents = new HashMap<>();

  // // when
  // assertEquals(10, courseParticipatns.getAvailableSeats());
  // // assertTrue(courseParticipatns.getRegisteredStudentsListList().isEmpty());

  // courseParticipatns.enrollStudent(studentA);
  // enrolledStudents.put(studentA.getId(), studentA);

  // // then
  // assertEquals(9, courseParticipatns.getAvailableSeats());
  // //
  // assertTrue(courseParticipatns.getRegisteredStudentsListList().equals(enrolledStudents));

  // // when
  // courseParticipatns.enrollStudent(studentB);
  // enrolledStudents.put(studentB.getId(), studentB);

  // // then
  // assertEquals(8, courseParticipatns.getAvailableSeats());
  // //
  // assertTrue(courseParticipatns.getRegisteredStudentsListList().equals(enrolledStudents));
  // }

  // @Test
  // public void testRemoveEnrolledStudents() {
  // // given
  // final Map<Long, Student> enrolledStudents = new HashMap<>();

  // courseParticipatns.enrollStudent(studentA);
  // courseParticipatns.enrollStudent(studentB);
  // enrolledStudents.put(studentA.getId(), studentA);
  // enrolledStudents.put(studentB.getId(), studentB);

  // assertEquals(8, courseParticipatns.getAvailableSeats());
  // //
  // assertTrue(courseParticipatns.getRegisteredStudentsListList().equals(enrolledStudents));

  // // when
  // courseParticipatns.removeStudent(studentA);
  // enrolledStudents.remove(studentA.getId());

  // // then
  // assertEquals(9, courseParticipatns.getAvailableSeats());
  // //
  // assertTrue(courseParticipatns.getRegisteredStudentsListList().equals(enrolledStudents));
  // }

  // @Test
  // public void testWaitingStudentsList() {
  // // given
  // final CourseParticipants testCourseWithTwoSeats = new CourseParticipants();

  // testCourseWithTwoSeats.enrollStudent(studentA);
  // testCourseWithTwoSeats.enrollStudent(studentB);

  // assertEquals(0, testCourseWithTwoSeats.getAvailableSeats());
  // // assertEquals(2,
  // // testCourseWithTwoSeats.getRegisteredStudentsListList().size());
  // assertEquals(true, testCourseWithTwoSeats.checkIfCourseIsFull());
  // }
}
