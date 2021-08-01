package com.github.com.marcelomachadoxd.dslearn.entities.repositories;

import com.github.com.marcelomachadoxd.dslearn.entities.Course;
import com.github.com.marcelomachadoxd.dslearn.entities.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {
}
