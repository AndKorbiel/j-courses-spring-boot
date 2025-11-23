package com.example.courses.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.courses.entity.Course;
import com.example.courses.entity.CourseParticipants;
import com.example.courses.repository.CourseRepository;
import com.example.staff.entity.Teacher;
import com.example.staff.service.TeacherService;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
  private final CourseRepository courseRepository;
  private final TeacherService teacherService;

  public CourseService(CourseRepository courseRepository, TeacherService teacherService) {
    this.courseRepository = courseRepository;
    this.teacherService = teacherService;
  }

  public Iterable<Course> findAll() {
    return courseRepository.findAll();
  }

  public Optional<Course> findById(Long id) {
    return courseRepository.findById(id);
  }

  public Course addNewCourse(CourseApi newCourse) {
    CourseParticipants participants = new CourseParticipants(newCourse.availableSeats);
    Teacher courseTeacher = teacherService.findById(newCourse.teacherId).orElse(null);

    Course courseToSave = new Course(
        newCourse.description,
        newCourse.name,
        newCourse.availableSeats,
        newCourse.hoursPerWeek,
        courseTeacher,
        participants);

    return courseRepository.save(courseToSave);
  }

  @Transactional
  public Course updateOrAddCourse(Course course) {
    return courseRepository.save(course);
  }

  public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
  }
}
