package com.example.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.courses.Course;
import com.example.shared.Skills;
import com.example.staff.Teacher;

@Service
public class CoursesManager {
  private List<Course> coursesList = new ArrayList<>();

  public CoursesManager() {
    List<Skills> mrAskills = List.of(Skills.ENGLISH, Skills.MATH);
    Teacher mrA = new Teacher("Mr Andrew", 10, mrAskills);
    Course enligshCourse = new Course("English course for students", "English course", mrA, 20, 8);

    this.coursesList.add(enligshCourse);
  }

  public List<Course> getCoursesList() {
    return this.coursesList;
  }

  public Optional<Course> getCourseById(int courseId) {
    return this.coursesList.stream().filter(item -> item.id == courseId).findFirst();
  }

  public boolean addCourse(Course newCourse) {
    System.out.println("newCourse" + newCourse);
    return this.coursesList.add(newCourse);
  }

  public boolean removeCourse(int courseId) {
    return this.coursesList.removeIf(course -> course.id == courseId);
  }
}
