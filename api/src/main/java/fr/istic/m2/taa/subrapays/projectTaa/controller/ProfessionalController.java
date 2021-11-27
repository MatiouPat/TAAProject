package fr.istic.m2.taa.subrapays.projectTaa.controller;

import fr.istic.m2.taa.subrapays.projectTaa.dto.ProfessionalDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.mapper.ProfessionalMapper;
import fr.istic.m2.taa.subrapays.projectTaa.repository.ProfessionalRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Professional")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessionalController
{

    private ProfessionalRepository professionalRepository;

    @Autowired
    public void setProfessionalRepository(ProfessionalRepository professionalRepository)
    {
        this.professionalRepository = professionalRepository;
    }

    @PostMapping(value="/create")
    public void create(@RequestBody Object professional)
    {
    	System.out.println("creating new professional" + professional);
    	/*try {
            professionalRepository.save(professional);
        }catch (Exception e) {
            throw e;
        }*/
        System.out.println("professional created");
    }

    @GetMapping(value = "/getProfessionals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Professional>> getListProfessional()
    {
    	List<Professional> l = professionalRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(l);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Professional> read(@PathVariable long id)
    {
        Professional professionnal = null;
        try {
            professionnal = professionalRepository.getById(id);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(professionnal);
    }

    

    
    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Professional> update(@PathVariable long id, @RequestBody Professional professional)
    {
        Professional professionalUpdated = null;
        try {
            professionalUpdated = professionalRepository.getById(id);
            professionalUpdated.setJob(professional.getJob());
            professionalUpdated.setAgenda(professional.getAgenda());
            professionalUpdated.setAccount(professional.getAccount());
            professionalUpdated.setAppointments(professional.getAppointments());
            professionalUpdated = professionalRepository.save(professionalUpdated);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(professionalUpdated);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Professional> delete(@PathVariable long id)
    {
        try {
            professionalRepository.deleteById(id);
        }catch (Exception e){
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
