package fr.istic.m2.taa.subrapays.projectTaa.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="appointment")
public class Appointment implements Serializable 
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int duration;

    private String subject;

    private boolean libre;

    @ManyToOne
    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonBackReference
    private Professional professional;

    @ManyToOne
    @JsonBackReference
    private Agenda agenda;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public Professional getProfessionnal() {
        return professional;
    }

    public void setProfessionnal(Professional professional) {
        this.professional = professional;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
    	return "Appointment{" +
                "id=" + id +
                ", user=" + user.firstname +
                " " + user.lastname +
                ", professional=" + professional.firstname +
                " " + professional.lastname +
                ", job=" + professional.getJob();
    }
}

