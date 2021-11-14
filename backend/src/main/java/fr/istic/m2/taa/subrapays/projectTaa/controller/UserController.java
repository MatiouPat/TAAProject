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

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserController
{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> create(@RequestBody User user)
    {
        try {
            userRepository.save(user);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value="/users",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers()
    {
    	List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping(value="/usersTest",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsersTest()
    {
    	List<User> l = userRepository.findAll();
    	System.out.println("size="+l.size());
//    	m.addAttribute("list", l);
    	try {
    		return new ResponseEntity<List<User>>(l,HttpStatus.OK);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return new ResponseEntity<List<User>>(l,HttpStatus.OK);
    }

    
    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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
