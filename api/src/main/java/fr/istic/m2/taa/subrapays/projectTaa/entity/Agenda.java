package fr.istic.m2.taa.subrapays.projectTaa.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="agenda")
public class Agenda implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @OneToOne(mappedBy = "agenda", cascade = CascadeType.ALL)
    private Professional professional;

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

    @JsonManagedReference
    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    @JsonManagedReference
    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    @Override
    public String toString() {
    	return "Aganda{" +
                "id=" + id +
                ", url=" + url +
                ", professionnel=" + professional.firstname +
                " " + professional.lastname +
                ", job=" + professional.getJob();
    }

}
