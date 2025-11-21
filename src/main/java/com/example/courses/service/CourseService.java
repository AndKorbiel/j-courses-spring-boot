package com.example.courses.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.courses.entity.Course;
import com.example.courses.repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
  private final CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public Iterable<Course> findAll() {
    return courseRepository.findAll();
  }

  public Optional<Course> findById(Long id) {
    return courseRepository.findById(id);
  }

  public Course addNewCourse(Course newCourse) {
    return courseRepository.save(newCourse);
  }

  @Transactional
  public Course updateOrAddCourse(Course course) {
    return courseRepository.save(course);
  }

  public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
  }
}
