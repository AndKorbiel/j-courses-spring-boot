package com.example.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.staff.entity.Teacher;
import com.example.staff.reposiotry.TeacherRepository;
import com.example.shared.Skills;

@Service
public class TeacherService {
  @Autowired
  private TeacherRepository teacherRepository;

  public TeacherService(TeacherRepository teacherRepository) {
    this.teacherRepository = teacherRepository;
  }

  public Iterable<Teacher> getTeachersList() {
    return teacherRepository.findAll();
  }

  public void addNewTeacher(Teacher newTeacher) {
    teacherRepository.save(newTeacher);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void runExample() {
    Teacher teacherA = new Teacher("Teacher A", 10, List.of(Skills.ENGLISH, Skills.MATH));
    teacherRepository.save(teacherA);

    List<Teacher> teachers = teacherRepository.findBySalaryGreaterThan(5);
    System.out.println(teachers);
  }
}
