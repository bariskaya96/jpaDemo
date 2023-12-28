package com.example.jpaproject.course.springdatajpa;

import com.example.jpaproject.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CourseSpringDataJapRepository extends JpaRepository<Course, Long> {

  List<Course> findByAuthor(String author);
}
