package com.example.courses;

import com.example.staff.entity.Teacher;

public class MusicCourse extends Course {
  public MusicCourse(Teacher courseTeacher, int availableSeats) {
    super("Music course for students", "Music course", courseTeacher, availableSeats, 2);
  }
}
