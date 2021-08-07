package com.github.com.marcelomachadoxd.dslearn.DTO;

import com.github.com.marcelomachadoxd.dslearn.entities.Notification;

import java.io.Serializable;
import java.time.Instant;


public class NotificationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String text;

    private Instant moment;
    private Boolean read;
    private String route;
    private Long userID;

    public NotificationDTO() {
    }

    public NotificationDTO(Long id, String text, Instant moment, Boolean read, String route, Long userID) {
        this.id = id;
        this.text = text;
        this.moment = moment;
        this.read = read;
        this.route = route;
        this.userID = userID;
    }

    public NotificationDTO(Notification entity) {
        this.id = entity.getId();
        this.text = entity.getText();
        this.moment = entity.getMoment();
        this.read = entity.getRead();
        this.route = entity.getRoute();
        this.userID = entity.getUser().getId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
