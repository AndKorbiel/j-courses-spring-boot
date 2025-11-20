package com.example.staff.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.Teacher;
import com.example.staff.service.TeacherService;

@RestController
@RequestMapping("/staff/teacher")
public class TeacherController {
  private final TeacherService teacherService;

  @Autowired
  public TeacherController(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @GetMapping("/getAll")
  public Iterable<Teacher> getTeachersList() {
    return teacherService.findAll();
  }

  @GetMapping("/getById")
  public Optional<Teacher> getTeacherById(@RequestParam Long id) {
    return teacherService.findById(id);
  }

  @PostMapping("/addTeacher")
  public void addTeacher(@RequestBody Teacher newTeacher) {
    teacherService.addNewTeacher(newTeacher);
  }

  @PutMapping("/updateTeacher")
  public void updateTeacher(@RequestBody Teacher teacher) {
    teacherService.updateOrInsertTeacher(teacher);
  }

  @DeleteMapping("/deleteTeacher")
  public void deleteTeacher(Long id) {
    teacherService.deleteTeacher(id);
  }

}
