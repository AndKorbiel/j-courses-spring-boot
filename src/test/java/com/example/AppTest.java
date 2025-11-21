package com.example;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.staff.entity.Teacher;
import com.example.courses.entity.Course;
import com.example.shared.Skills;

public class AppTest {
  // given
  private final List<Skills> mrAskills = List.of(Skills.ENGLISH, Skills.MATH);
  private final Teacher mrA = new Teacher("Mr Andrew", 10, mrAskills);

  @Test
  public void testCalcuatingTeacherSalaryBasedOnCourseHours() {
    // when
    new Course("English course for students", "English course", mrA, 20, 8);

    // 10 * 4 * 8
    Double expectedResult = 320d;

    // then
    assertEquals(expectedResult, mrA.countMonthlySalary(), 2);

    // when
    new Course("Math course for students", "Math course", mrA, 10, 4);

    // 320 + (10 * 4 * 4)
    Double expectedSumResult = 480d;

    // then
    assertEquals(expectedSumResult, mrA.countMonthlySalary(), 2);
  }
}
