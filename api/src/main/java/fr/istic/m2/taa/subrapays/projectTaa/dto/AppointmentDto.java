package fr.istic.m2.taa.subrapays.projectTaa.dto;

import java.io.Serializable;

import javax.validation.constraints.*;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Agenda;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.entity.User;

public class AppointmentDto implements Serializable{
	
    @Positive
    @NotNull
	private int duration;

    @NotBlank(message="you must precise the object of the appointmnet")
    private String subject;

    @NotNull
    @AssertTrue
    private boolean libre;

    @NotNull(message="you must give your name")
    private User user;

    @NotNull(message="you must select the professional you want to meet")
    private Professional professional;

    private Agenda agenda;

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
    	return "Aganda{user=" + user.firstname +" "+ user.lastname +", professional=" + professional.firstname +" "+ professional.lastname +", job=" + professional.getJob();
    }


}
