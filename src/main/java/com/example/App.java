package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.Course;
import com.example.shared.Skills;
import com.example.staff.Teacher;

@SpringBootApplication
@RestController
public class App {
  public static void main(String[] args) {
    System.out.println("Starting app");
    SpringApplication.run(App.class, args);

  }

  @GetMapping("/getAll")
  public List<Course> hello() {
    List<Skills> mrAskills = List.of(Skills.ENGLISH, Skills.MATH);
    Teacher mrA = new Teacher("Mr Andrew", 10, mrAskills);
    Course enligshCourse = new Course("English course for students", "English course", mrA, 20, 8);

    return List.of(enligshCourse);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }
}
