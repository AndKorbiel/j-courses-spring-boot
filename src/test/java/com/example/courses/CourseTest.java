package com.example.courses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.staff.entity.Teacher;
import com.example.courses.entity.Course;
import com.example.shared.Skills;

public class CourseTest {
  // given
  String description = "Test decription";
  String name = "Test name";
  int availableSeats = 10;
  private List<Skills> teacherSkills = new ArrayList<>();

  private final Teacher testTeacher = new Teacher("Test teacher", 10, teacherSkills);
  private final Course testCourse = new Course(description, name, testTeacher, 10, 8);

  @Test
  public void testCourseConstructor() {
    assertEquals(name, testCourse.getName());
    assertEquals(description, testCourse.getDescription());
    // assertEquals(10, testCourse.courseParticipants.getAvailableSeats());
    // assertEquals("Test teacher", testCourse.courseTeacher.name);
    // assertEquals(1, testCourse.courseTeacher.id);
    assertEquals(8, testCourse.getHoursPerWeek());
  }
}
