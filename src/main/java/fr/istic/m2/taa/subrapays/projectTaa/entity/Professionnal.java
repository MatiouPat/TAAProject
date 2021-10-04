package fr.istic.m2.taa.subrapays.projectTaa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Professionnal extends User
{
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Agenda agenda;

    @OneToOne
    private Account account;

    @OneToMany
    private Collection<Appointment> appointments;
    
    private String Job;


	public Professionnal()
    {

    }

    public Long getId()
    {
        return id;
    }

    public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public void setId(Long id)
    {
        this.id = id;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
