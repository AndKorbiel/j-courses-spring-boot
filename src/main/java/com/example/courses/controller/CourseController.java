package com.example.courses.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.entity.Course;
import com.example.courses.service.CourseApi;
import com.example.courses.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
  public final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping("/getAll")
  public Iterable<Course> getAll() {
    return courseService.findAll();
  }

  @GetMapping("/getById")
  public Optional<Course> getById(@RequestParam Long id) {
    return courseService.findById(id);
  }

  @PostMapping("/add")
  public Course add(@RequestBody CourseApi newCourse) {
    return courseService.addNewCourse(newCourse);
  }

  @PutMapping("/update")
  public Course update(@RequestBody Course course) {
    return courseService.updateOrAddCourse(course);
  }

  @DeleteMapping("/delete")
  public void delete(@RequestParam Long id) {
    courseService.deleteCourse(id);
  }
}
