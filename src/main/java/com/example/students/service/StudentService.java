package com.example.students.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.students.entity.Student;
import com.example.students.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Iterable<Student> findAll() {
    return studentRepository.findAll();
  }

  public Optional<Student> findById(Long id) {
    return studentRepository.findById(id);
  }

  public Student addNewStudent(Student newStudent) {
    return studentRepository.save(newStudent);
  }

  @Transactional
  public Student updateOrAddStudent(Student student) {
    return studentRepository.save(student);
  }

  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }
}
