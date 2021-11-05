package fr.istic.m2.taa.subrapays.projectTaa.web;

import fr.istic.m2.taa.subrapays.projectTaa.repository.ProfessionnalRepository;
import fr.istic.m2.taa.subrapays.projectTaa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController
{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

}
