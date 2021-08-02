package com.github.com.marcelomachadoxd.dslearn.entities.repositories;

import com.github.com.marcelomachadoxd.dslearn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
