package fr.istic.m2.taa.subrapays.projectTaa.dto;

import java.util.Collection;

import javax.validation.constraints.*;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Agenda;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Appointment;

public class ProfessionalDto extends UserDto{

	private Agenda agenda;

    @NotNull
    private Account account;

    private Collection<Appointment> appointments;
    
    @NotBlank(message="you must precise you job")
    @Size(min=3,message="job must be longer than 3 characters")
    private String job;

    public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Professional{firstname=" + this.getFirstname() +
                ", lastname=" + this.getLastname() +
                ", job=" + job +          
                '}';
    }


}
