package fr.istic.m2.taa.subrapays.projectTaa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Agenda
{

    @Id
    @GeneratedValue
    private Long id;

    private String url;

    @OneToOne
    private Professional professionnal;

    @OneToMany
    private Collection<Appointment> appointments;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Professional getProfessionnal() {
        return professionnal;
    }

    public void setProfessional(Professional professionnal) {
        this.professionnal = professionnal;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }
}
