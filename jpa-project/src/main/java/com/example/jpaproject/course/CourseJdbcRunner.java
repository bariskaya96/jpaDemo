package com.example.jpaproject.course;

import com.example.jpaproject.course.Course;
import com.example.jpaproject.course.jdbc.CourseJdbcRepository;
import com.example.jpaproject.course.jpa.CourseJpaRepository;
import com.example.jpaproject.course.springdatajpa.CourseSpringDataJapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseJdbcRunner implements CommandLineRunner {

  @Autowired
  private CourseJdbcRepository jdbcRepository;

  @Autowired
  private CourseJpaRepository jpaRepository;

  @Autowired
  private CourseSpringDataJapRepository springDataJapRepository;

  @Override
  public void run(String... args) throws Exception {
    jdbcRepository.insert(new Course(1, "Intro to JPA", "Baris Kaya"));
    jdbcRepository.insert(new Course(2, "Intro to AWS", "Jeff Bezos"));
    //jdbcRepository.insert(new Course(2, "Intro to AWS", "Jeff Bezos"));
    jdbcRepository.insert(new Course(3, "Intro to Spring Boot", "In28Minutes"));
    jdbcRepository.deleteById(1);
    System.out.println(jdbcRepository.findById(2));

    System.out.println("-------------------- JPA Starts --------------------");


    jpaRepository.insert(new Course(4, "Intro to JPA", "28 minutes"));
    jpaRepository.insert(new Course(5, "Intro to Spring Boot JPA", "In28Minutes"));
    jpaRepository.insert(new Course(5, "Intro to Spring Boot JPA6666", "In28Minutes"));

    System.out.println(jpaRepository.findById(6));

    //jpaRepository.deleteById(7); Exception!!!!

    System.out.println(jpaRepository.findById(5));

    System.out.println("-------------------- Spring Data JPA Starts --------------------");

    springDataJapRepository.save(new Course(6, "Intro to Spring Data JPA", "In28Minutes"));
    springDataJapRepository.save(new Course(7, "XXXX", "In28Minutes"));
    springDataJapRepository.save(new Course(7, "Intro to Spring Boot JP1231231A6666", "In28Minutes"));

    System.out.println(springDataJapRepository.findById(6L));
    springDataJapRepository.deleteById(7L);
    springDataJapRepository.deleteById(7L);
    System.out.println(springDataJapRepository.findById(7L));

    springDataJapRepository.findAll();
    springDataJapRepository.count();

    List<Course> courseList = springDataJapRepository.findByAuthor("In28Minutes");
    courseList.stream().forEach(k -> System.out.println("Id: '" + k.getId() + "' Name: '" + k.getName() + "'."));
  }
}
