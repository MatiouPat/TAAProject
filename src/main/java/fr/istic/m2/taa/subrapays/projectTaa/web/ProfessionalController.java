package fr.istic.m2.taa.subrapays.projectTaa.web;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Professionnal;
import fr.istic.m2.taa.subrapays.projectTaa.repository.ProfessionnalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Professionnal")
public class ProfessionnalController
{

    private ProfessionnalRepository professionnalRepository;

    @Autowired
    public void setAppointmentDao(ProfessionnalRepository professionalRepository)
    {
        this.professionnalRepository = professionalRepository;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Professionnal> create(@RequestBody Professionnal professionnal)
    {
        try {
            professionnalRepository.save(professionnal);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(professionnal);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Professionnal> read(@PathVariable long id)
    {
        Professionnal professionnal = null;
        try {
            professionnal = professionnalRepository.getById(id);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(professionnal);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Professionnal> update(@PathVariable long id, @RequestBody Professionnal professionnal)
    {
        Professionnal professionnalUpdated = null;
        try {
            professionnalUpdated = professionnalRepository.getById(id);
            professionnalUpdated.setProfession(professionnal.getProfession());
            professionnalUpdated.setAgenda(professionnal.getAgenda());
            professionnalUpdated.setAccount(professionnal.getAccount());
            professionnalUpdated.setAppointments(professionnal.getAppointments());
            professionnalUpdated = professionnalRepository.save(professionnalUpdated);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(professionnalUpdated);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Professionnal> delete(@PathVariable long id)
    {
        try {
            professionnalRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
