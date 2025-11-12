package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.Course;

@RestController
public class CoursesApi {
  private final CoursesManager coursesManager;

  @Autowired
  public CoursesApi(CoursesManager coursesManager) {
    this.coursesManager = coursesManager;
  }

  @GetMapping("/getAll")
  public List<Course> getCoursesList() {
    return coursesManager.getCoursesList();
  }

  @PostMapping("/addCourse")
  public boolean addCourse(@RequestBody Course newCourse) {
    return coursesManager.addCourse(newCourse);
  }
}
