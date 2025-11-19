package com.example.staff;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.staff.entity.Teacher;
import com.example.shared.Skills;

public class TeacherTest {
  // given
  private List<Skills> skills = new ArrayList<>();
  private final Teacher testTeacher = new Teacher("Test teacher", 10, skills);

  @Test
  public void testGetterFunctions() {
    // when
    skills.add(Skills.ENGLISH);
    skills.add(Skills.MATH);

    // then
    assertEquals(new ArrayList<Skills>(List.of(Skills.ENGLISH, Skills.MATH)), testTeacher.getSkills());
    assertEquals(10, testTeacher.getSalary(), 2);
  }

  @Test
  public void testCountSalary() {
    // when
    testTeacher.addHours(10d);

    // then
    assertEquals(400, testTeacher.countMonthlySalary(), 2);

  }
}
