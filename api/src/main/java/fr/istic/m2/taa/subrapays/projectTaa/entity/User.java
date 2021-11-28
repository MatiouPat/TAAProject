package fr.istic.m2.taa.subrapays.projectTaa.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="user")
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}
	public User(String lastname, String firstname) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String lastname;

    public String firstname;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    @Override
    public String toString() {
    	return "User{id = " + id + ", firstname = " + firstname + ", lastname = " + lastname;
    }

}
