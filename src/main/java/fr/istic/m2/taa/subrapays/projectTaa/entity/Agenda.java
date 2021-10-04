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
    private Professionnal professionnal;

    @OneToMany
    private Collection<Appointment> appointments;

    public Agenda()
    {

    }

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

    public Professionnal getProfessionnal() {
        return professionnal;
    }

    public void setProfessional(Professionnal professionnal) {
        this.professionnal = professionnal;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }
}
