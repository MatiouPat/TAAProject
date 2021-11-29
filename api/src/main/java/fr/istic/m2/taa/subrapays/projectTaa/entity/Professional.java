package fr.istic.m2.taa.subrapays.projectTaa.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="professional")
public class Professional extends User
{

	@OneToOne
    private Agenda agenda;

    @OneToOne
    private Account account;

    @OneToMany
    @JsonManagedReference
    private Collection<Appointment> appointments;
    
    private String job;

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@JsonBackReference
    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @JsonBackReference
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @JsonBackReference
    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Professional{" +
                "id=" + id +
                ", firstname=" + this.firstname +
                ", lastname=" + this.lastname +
                ", job=" + job +          
                '}';
    }


}
