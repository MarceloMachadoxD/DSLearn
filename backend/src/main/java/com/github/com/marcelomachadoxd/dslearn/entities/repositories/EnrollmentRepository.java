package com.github.com.marcelomachadoxd.dslearn.entities.repositories;

import com.github.com.marcelomachadoxd.dslearn.entities.Enrollment;
import com.github.com.marcelomachadoxd.dslearn.entities.PK.EnrollmentPK;
import com.github.com.marcelomachadoxd.dslearn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
