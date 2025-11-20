package com.example.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.staff.entity.Teacher;
import com.example.staff.reposiotry.TeacherRepository;

import jakarta.transaction.Transactional;

import com.example.shared.Skills;

@Service
public class TeacherService {
  @Autowired
  private TeacherRepository teacherRepository;

  public TeacherService(TeacherRepository teacherRepository) {
    this.teacherRepository = teacherRepository;
  }

  public Iterable<Teacher> findAll() {
    return teacherRepository.findAll();
  }

  public Optional<Teacher> findById(Long id) {
    return teacherRepository.findById(id);
  }

  public Teacher addNewTeacher(Teacher newTeacher) {
    return teacherRepository.save(newTeacher);
  }

  @Transactional
  public Teacher updateOrInsertTeacher(Teacher teacher) {
    return teacherRepository.save(teacher);
  }

  public void deleteTeacher(Long id) {
    teacherRepository.deleteById(id);
  }

  // adnotation used for seeding DB on run
  @EventListener(ApplicationReadyEvent.class)
  public void runExample() {
    Teacher teacherA = new Teacher("Teacher A", 10, List.of(Skills.ENGLISH, Skills.MATH));
    teacherRepository.save(teacherA);

    // logs out result to custom repository method to console
    List<Teacher> teachers = teacherRepository.findBySalaryGreaterThan(5);
    System.out.println(teachers);
  }
}
