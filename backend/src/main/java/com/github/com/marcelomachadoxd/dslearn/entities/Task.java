package com.github.com.marcelomachadoxd.dslearn.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_task")
public class Task extends Lesson implements Serializable {
    private static final long serialVersionUID =1L;

    private String description;
    private Integer questionCount;
    private Integer approvalCount;
    private Double weight = 1.0d;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dueDate;

    public Task() {}

    public Task(Long id, String title, Integer position, Section section, String description, Integer questionCount, Integer approvalCount, Double weight, Instant dueDate) {
        super(id, title, position, section);
        this.description = description;
        this.questionCount = questionCount;
        this.approvalCount = approvalCount;
        this.weight = weight;
        this.dueDate = dueDate;
    }
}
