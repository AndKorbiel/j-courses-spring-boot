package com.example.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.Teacher;
import com.example.staff.service.TeacherService;

@RestController
public class TeacherController {
  private final TeacherService teacherService;

  @Autowired
  public TeacherController(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @GetMapping("/getAll")
  public Iterable<Teacher> getTeachersList() {
    return teacherService.getTeachersList();
  }

  @PostMapping("/addTeacher")
  public void addTeacher(@RequestBody Teacher newTeacher) {
    teacherService.addNewTeacher(newTeacher);
  }

  // @PostMapping("/addCourse")
  // public boolean addCourse(@RequestBody Course newCourse) {
  // return coursesManager.addCourse(newCourse);
  // }
}
