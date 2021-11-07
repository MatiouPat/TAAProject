package fr.istic.m2.taa.subrapays.projectTaa.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class Account implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
