package com.github.com.marcelomachadoxd.dslearn.entities;

import com.github.com.marcelomachadoxd.dslearn.entities.PK.EnrollmentPK;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {

    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant EnrollMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment = null;
    private boolean avaliable = true;
    private boolean onlyUpdate;

    @ManyToMany(mappedBy = "enrollmentsDone")
    private Set<Lesson> LessonsDone = new HashSet<>();

    @OneToMany(mappedBy = "enrollment")
    private List<Deliver> deliveries = new ArrayList<>();

    public Enrollment() {
    }

    public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean avaliable, boolean onlyUpdate) {
        id.setUser(user);
        id.setOffer(offer);
        EnrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.avaliable = avaliable;
        this.onlyUpdate = onlyUpdate;
    }


    public User getStudent(){
        return id.getUser();
    }

    public void setStudent(User user){
        id.setUser(user);
    }

    public Offer getOffer() {
        return id.getOffer();
    }
    public void setOffer(Offer offer){
        id.setOffer(offer);
    }
        public Instant getEnrollMoment() {
        return EnrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        EnrollMoment = enrollMoment;
    }

    public Instant getRefundMoment() {
        return refundMoment;
    }

    public void setRefundMoment(Instant refundMoment) {
        this.refundMoment = refundMoment;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public boolean isOnlyUpdate() {
        return onlyUpdate;
    }

    public void setOnlyUpdate(boolean onlyUpdate) {
        this.onlyUpdate = onlyUpdate;
    }

    public List<Deliver> getDeliveries() {
        return deliveries;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Enrollment other = (Enrollment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
