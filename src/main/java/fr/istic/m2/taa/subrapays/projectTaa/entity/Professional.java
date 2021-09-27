package fr.istic.m2.taa.subrapays.projectTaa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Professional extends User
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

    public Professional()
    {

    }

    public Long getId()
    {
        return id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
