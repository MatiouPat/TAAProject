package fr.istic.m2.taa.subrapays.projectTaa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    private String lastname;

    private String firstname;

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
}
