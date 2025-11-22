package com.example.courses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.courses.entity.CourseParticipants;

@Repository
public interface CourseParticipantsRepository extends CrudRepository<CourseParticipants, Long> {
}