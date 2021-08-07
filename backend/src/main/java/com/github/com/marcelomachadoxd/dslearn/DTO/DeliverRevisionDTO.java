package com.github.com.marcelomachadoxd.dslearn.DTO;

import com.github.com.marcelomachadoxd.dslearn.entities.enums.Status;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.Instant;

public class DeliverRevisionDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String feedback;
    private Integer correctCount;
    private Status deliverStatus;

    public DeliverRevisionDTO() {
    }

    public DeliverRevisionDTO(String feedback, Integer correctCount, Status deliverStatus) {
        this.feedback = feedback;
        this.correctCount = correctCount;
        this.deliverStatus = deliverStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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
}
