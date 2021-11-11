package fr.istic.m2.taa.subrapays.projectTaa.dto;

import java.io.Serializable;

import javax.validation.constraints.*;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;

public class AccountDto implements Serializable{

	@NotBlank(message="login cannot be empty")
    private String login;

	@NotBlank(message="password cannot be empty")
	@Size(min=3,message="password must be longer than 3 characters")
    private String password;

    @NotNull
	private Professional professional;

    
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
    
    @Override
    public String toString() {
    	return "Appointment{login=" + login +
                ", password=" + password +
                ", job=" + professional.getJob();
    }
}
