package com.github.com.marcelomachadoxd.dslearn.entities.repositories;

import com.github.com.marcelomachadoxd.dslearn.entities.Resource;
import com.github.com.marcelomachadoxd.dslearn.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
