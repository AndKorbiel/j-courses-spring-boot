package com.example.courses;

import com.example.staff.entity.Teacher;

public class EnglishCourse extends Course {
  public EnglishCourse(Teacher courseTeacher, int availableSeats) {
    super("English course for students", "English course", courseTeacher, availableSeats, 8);
  }
}
