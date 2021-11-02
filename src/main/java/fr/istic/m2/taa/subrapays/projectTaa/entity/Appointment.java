package fr.istic.m2.taa.subrapays.projectTaa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Appointment
{
    @Id
    @GeneratedValue
    private Long id;

    private int duration;

    private String subject;

    private boolean libre;

    @ManyToOne
    private User user;

    @ManyToOne
    private Professionnal professionnal;

    @ManyToOne
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

    public Professionnal getProfessionnal() {
        return professionnal;
    }

    public void setProfessionnal(Professionnal professionnal) {
        this.professionnal = professionnal;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
