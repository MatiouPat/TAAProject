package fr.istic.m2.taa.subrapays.projectTaa.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.Collection;

import javax.validation.constraints.*;

public class ProfessionalDto {

    private String firstname;

    private String lastname;

    @NotBlank(message="you must precise you job")
    @Size(min=3,message="job must be longer than 3 characters")
    private String job;

    private String login;

    private String password;


	public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    @Override
    public String toString() {
        return "Professional{firstname=" + this.getFirstname() +
                ", lastname=" + this.getLastname() +
                ", job=" + job +          
                '}';
    }


}
