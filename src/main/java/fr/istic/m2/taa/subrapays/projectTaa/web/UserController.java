package fr.istic.m2.taa.subrapays.projectTaa.web;

import fr.istic.m2.taa.subrapays.projectTaa.entity.User;
import fr.istic.m2.taa.subrapays.projectTaa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController
{

    private UserRepository userRepository;

    @Autowired
    public void setuserRepository(UserRepository userRepository)
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
    public ResponseEntity<User> read(@PathVariable long id)
    {
        User professionnal = null;
        try {
            professionnal = userRepository.getById(id);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(professionnal);
    }

    
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<User>> getListUser()
    {
    	List<User> l = new ArrayList<User>();
        try {
            l = userRepository.findAll();
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(l);
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
