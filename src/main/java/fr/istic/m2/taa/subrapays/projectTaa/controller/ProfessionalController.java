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
public class ProfessionalController
{

	@Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    public void setProfessionalRepository(ProfessionalRepository professionalRepository)
    {
        this.professionalRepository = professionalRepository;
    }

    @PostMapping(value="Professional/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody ProfessionalDto professional)
    {
    	System.out.println("creating new professional");
    	try {
            professionalRepository.save(ProfessionalMapper.INSTANCE.professionalDtoToProfessional(professional));
        }catch (Exception e) {
            throw e;
        }
        System.out.println("professional created");
    }

    @GetMapping(value = "Professional/getProfessionals", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Professional>> getListProfessional()
    {
    	List<Professional> l = professionalRepository.findAll();
    	System.out.println("creating pro list from database");
    	HttpHeaders h=new HttpHeaders(); 
    	h.add("Access-Control-Allow-Methods", "POST, GET"); 
    	h.add("Access-Control-Allow-Origin", "*");
        return ResponseEntity.status(HttpStatus.OK).headers(h).body(l);
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
