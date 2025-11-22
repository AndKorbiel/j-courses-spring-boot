package com.example.courses.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.courses.entity.CourseParticipants;
import com.example.courses.repository.CourseParticipantsRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseParticipantsService {
  private final CourseParticipantsRepository courseParticipantsRepository;

  public CourseParticipantsService(CourseParticipantsRepository courseParticipantsRepository) {
    this.courseParticipantsRepository = courseParticipantsRepository;
  }

  public Iterable<CourseParticipants> findAll() {
    return courseParticipantsRepository.findAll();
  }

  public Optional<CourseParticipants> findById(Long id) {
    return courseParticipantsRepository.findById(id);
  }

  public CourseParticipants addNewCourse(CourseParticipants newCourse) {
    return courseParticipantsRepository.save(newCourse);
  }

  @Transactional
  public CourseParticipants updateOrAddCourse(CourseParticipants course) {
    return courseParticipantsRepository.save(course);
  }

  public void deleteCourse(Long id) {
    courseParticipantsRepository.deleteById(id);
  }
}
