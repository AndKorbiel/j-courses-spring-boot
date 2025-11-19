package com.example.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.shared.Skills;

@Service
public class TeacherManager {
  @Autowired
  private TeacherRepo teacherRepo;

  public TeacherManager(TeacherRepo teacherRepo) {
    this.teacherRepo = teacherRepo;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void runExample() {
    Teacher teacherA = new Teacher("Teacher A", 10, List.of(Skills.ENGLISH, Skills.MATH));
    teacherRepo.save(teacherA);

    List<Teacher> teachers = teacherRepo.findBySalaryGreaterThan(5);
    System.out.println(teachers);
  }
}
