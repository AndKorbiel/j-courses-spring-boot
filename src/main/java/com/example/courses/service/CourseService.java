package com.example.courses.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.courses.entity.Course;
import com.example.courses.repository.CourseRepository;
import com.example.courses.service.payload.CoursePayload;
import com.example.courses.service.payload.CourseStudentPayload;
import com.example.staff.entity.Teacher;
import com.example.staff.service.TeacherService;
import com.example.students.entity.Student;
import com.example.students.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
  private final CourseRepository courseRepository;
  private final TeacherService teacherService;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, TeacherService teacherService,
      StudentService studentService) {
    this.courseRepository = courseRepository;
    this.teacherService = teacherService;
    this.studentService = studentService;
  }

  public Iterable<Course> findAll() {
    return courseRepository.findAll();
  }

  public Optional<Course> findById(Long id) {
    return courseRepository.findById(id);
  }

  public Course addNewCourse(CoursePayload newCourse) {
    Teacher courseTeacher = teacherService.findById(newCourse.teacherId).orElse(null);

    Course courseToSave = new Course(
        newCourse.description,
        newCourse.name,
        newCourse.availableSeats,
        newCourse.hoursPerWeek,
        courseTeacher);

    return courseRepository.save(courseToSave);
  }

  public Course enrollStudentForCourse(CourseStudentPayload enrollStudentPayload) {
    Student student = studentService.findById(enrollStudentPayload.student.id).orElse(null);
    Course course = courseRepository.findById(enrollStudentPayload.courseId).orElse(null);

    course.enrollStudent(student);

    return courseRepository.save(course);
  }

  @Transactional
  public Course updateOrAddCourse(Course course) {
    return courseRepository.save(course);
  }

  public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
  }
}
