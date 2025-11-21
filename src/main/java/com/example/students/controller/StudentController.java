package com.example.students.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.students.entity.Student;
import com.example.students.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/getAll")
  public Iterable<Student> getAll() {
    return studentService.findAll();
  }

  @GetMapping("/getById")
  public Optional<Student> getById(@RequestParam Long id) {
    return studentService.findById(id);
  }

  @PostMapping("/add")
  public Student add(@RequestBody Student newStudent) {
    return studentService.addNewStudent(newStudent);
  }

  @PutMapping("/update")
  public Student update(@RequestBody Student student) {
    return studentService.updateOrAddStudent(student);
  }

  @DeleteMapping("/delete")
  public void delete(@RequestParam Long id) {
    studentService.deleteStudent(id);
  }
}
