package fr.istic.m2.taa.subrapays.projectTaa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="professional")
public class Professional extends User implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
    private Agenda agenda;

    @OneToOne
    private Account account;

    @OneToMany
    private Collection<Appointment> appointments;
    
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
        return "Professional{" +
                "id=" + id +
                ", nom=" + this.firstname +
                ", prenom=" + this.lastname +
                ", job=" + job +          
                '}';
    }


}
