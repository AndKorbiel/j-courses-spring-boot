package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.Course;

@RestController
public class CoursesApi {
  // private final CoursesManager coursesManager;

  // @Autowired
  // public CoursesApi(CoursesManager coursesManager) {
  // this.coursesManager = coursesManager;
  // }

  // @GetMapping("/getAll")
  // public List<Course> getCoursesList() {
  // return coursesManager.getCoursesList();
  // }

  // @GetMapping("/getById")
  // public Optional<Course> getCourseById(@RequestParam int id) {
  // return coursesManager.getCourseById(id);
  // }

  // @PostMapping("/addCourse")
  // public boolean addCourse(@RequestBody Course newCourse) {
  // return coursesManager.addCourse(newCourse);
  // }

  // @DeleteMapping("/removeCourse")
  // public boolean removeCourse(@RequestParam int id) {
  // return coursesManager.removeCourse(id);
  // }
}
