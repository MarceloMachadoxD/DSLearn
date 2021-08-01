package com.github.com.marcelomachadoxd.dslearn.entities.repositories;

import com.github.com.marcelomachadoxd.dslearn.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
