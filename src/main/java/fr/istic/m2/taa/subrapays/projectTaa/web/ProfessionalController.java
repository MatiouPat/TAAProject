package fr.istic.m2.taa.subrapays.projectTaa.web;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.repository.ProfessionalRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Professional")
public class ProfessionalController
{

    private ProfessionalRepository professionalRepository;

    @Autowired
    public void setProfessionalRepository(ProfessionalRepository professionalRepository)
    {
        this.professionalRepository = professionalRepository;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Professional> create(@RequestBody Professional professional)
    {
        try {
            professionalRepository.save(professional);
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(professional);
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

    
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Professional>> getListProfessional()
    {
    	List<Professional> l = new ArrayList<Professional>();
        try {
            l = professionalRepository.findAll();
        }catch (Exception e) {
            throw e;
        }
        return ResponseEntity.status(HttpStatus.OK).body(l);
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
