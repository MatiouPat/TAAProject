package domain;

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
}