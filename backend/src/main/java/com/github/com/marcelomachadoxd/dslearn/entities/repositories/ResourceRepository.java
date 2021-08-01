package com.github.com.marcelomachadoxd.dslearn.entities.repositories;

import com.github.com.marcelomachadoxd.dslearn.entities.Reply;
import com.github.com.marcelomachadoxd.dslearn.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
