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

import com.example.courses.entity.CourseParticipants;
import com.example.courses.service.CourseParticipantsService;

@RestController
@RequestMapping("/course-participants")
public class CourseParticipantsController {
  public final CourseParticipantsService courseParticipantsService;

  public CourseParticipantsController(CourseParticipantsService courseParticipantsService) {
    this.courseParticipantsService = courseParticipantsService;
  }

  @GetMapping("/getAll")
  public Iterable<CourseParticipants> getAll() {
    return courseParticipantsService.findAll();
  }

  @GetMapping("/getById")
  public Optional<CourseParticipants> getById(@RequestParam Long id) {
    return courseParticipantsService.findById(id);
  }

  @PostMapping("/add")
  public CourseParticipants add(@RequestBody CourseParticipants newCourse) {
    return courseParticipantsService.addNewCourse(newCourse);
  }

  @PutMapping("/update")
  public CourseParticipants update(@RequestBody CourseParticipants course) {
    return courseParticipantsService.updateOrAddCourse(course);
  }

  @DeleteMapping("/delete")
  public void delete(@RequestParam Long id) {
    courseParticipantsService.deleteCourse(id);
  }

  // @PostMapping("/enroll-student")
  // public void enrollStudent(@RequestBody Long studentId, Long courseId) {
  // courseParticipantsService.enrollStudent(courseId, null);
  // }
}
