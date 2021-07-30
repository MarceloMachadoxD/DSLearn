package com.github.com.marcelomachadoxd.dslearn.entities;

import com.github.com.marcelomachadoxd.dslearn.entities.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_deliver")
public class Deliver implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uri;
    private String feedback;


    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    private Integer correctCount;

    private Status deliverStatus;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "offer_id"),
        @JoinColumn(name = "user_id")
    })
    private Enrollment enrollment;

    public Deliver() {
    }

    public Deliver(Long id, String uri, String feedback, Instant moment, Integer correctCount, Status deliverStatus, Lesson lesson, Enrollment enrollment) {
        this.id = id;
        this.uri = uri;
        this.feedback = feedback;
        this.moment = moment;
        this.correctCount = correctCount;
        this.deliverStatus = deliverStatus;
        this.lesson = lesson;
        this.enrollment = enrollment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    public Status getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(Status deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deliver deliver = (Deliver) o;
        return Objects.equals(id, deliver.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
