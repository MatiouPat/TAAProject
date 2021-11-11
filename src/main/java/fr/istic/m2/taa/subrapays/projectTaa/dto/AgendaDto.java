package fr.istic.m2.taa.subrapays.projectTaa.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.validation.constraints.*;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Appointment;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;

public class AgendaDto implements Serializable{

    private String url;

    @NotNull()
    private Professional professional;

    
    private Collection<Appointment> appointments;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    @Override
    public String toString() {
    	return "Aganda{url=" + url +
                ", professionnel=" + professional.firstname +
                " " + professional.lastname +
                ", job=" + professional.getJob();
    }

}
