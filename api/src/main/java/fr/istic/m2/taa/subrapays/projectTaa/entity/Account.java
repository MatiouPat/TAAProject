package fr.istic.m2.taa.subrapays.projectTaa.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="account")
public class Account implements Serializable
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Professional professional;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonManagedReference
    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
    
    @Override
    public String toString() {
    	return "Appointment{" +
                "id=" + id +
                ", login=" + login +
                ", password=" + password +
                ", job=" + professional.getJob();
    }
}
