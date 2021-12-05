package fr.istic.m2.taa.subrapays.projectTaa.controller;

import fr.istic.m2.taa.subrapays.projectTaa.entity.User;
import fr.istic.m2.taa.subrapays.projectTaa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sun.net.httpserver.Headers;

@Controller
@RequestMapping("/User")
public class UserController
{

    private UserRepository userRepository;

    @Autowired
    public void setuserRepository(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @PostMapping(value="/create")
    public void create(@RequestBody Object professional)
    {
    	/*System.out.println("creating new professional");
    	try {
            professionalRepository.save(professional);
        }catch (Exception e) {
            throw e;
        }*/
        System.out.println("professional created");
    }

//    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable long id)
    {
        User professionnal = null;
        try {
            professionnal = userRepository.getById(id);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(professionnal);
    }

    @GetMapping(value="/getUsers",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers()
    {
    	List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    
//    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user)
    {
        User UserUpdated = null;
        try {
            UserUpdated = userRepository.getById(id);
            UserUpdated.setFirstname(user.getFirstname());
            UserUpdated.setLastname(user.getLastname());
            UserUpdated = userRepository.save(UserUpdated);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(UserUpdated);
    }

//    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> delete(@PathVariable long id)
    {
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
