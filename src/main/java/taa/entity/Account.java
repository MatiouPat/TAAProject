package taa.entity;

import javax.persistence.*;


@Entity
@Table(name = "accounts")
public class Account
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    private Professionnal professional;

    public Account()
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

    public Professionnal getProfessional() {
        return professional;
    }

    public void setProfessional(Professionnal professional) {
        this.professional = professional;
    }
}
