package fr.istic.m2.taa.subrapays.projectTaa.controller;

import fr.istic.m2.taa.subrapays.projectTaa.dto.ProfessionalDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Agenda;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.mapper.ProfessionalMapper;
import fr.istic.m2.taa.subrapays.projectTaa.mapper.impl.ProfessionalMapperImpl;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AccountRepository;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AgendaRepository;
import fr.istic.m2.taa.subrapays.projectTaa.repository.ProfessionalRepository;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professional")
public class ProfessionalController
{

    private final ProfessionalMapper mapper;

    private ProfessionalRepository professionalRepository;

    private AccountRepository accountRepository;
    
    private AgendaRepository agendaRepository;

    public ProfessionalController(ProfessionalMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setProfessionalRepository(ProfessionalRepository professionalRepository,
    		AccountRepository accountRepository, AgendaRepository agendaRepository)
    {
        this.professionalRepository = professionalRepository;
        this.accountRepository = accountRepository;
        this.agendaRepository = agendaRepository;
    }

    @PostMapping(value="/create")
    public void create(@RequestBody ProfessionalDto professionalDto)
    {
        Professional professional = this.mapper.professionalDtoToProfessional(professionalDto);
    	System.out.println("creation du professionnel : " + professional);
        System.out.println(professional.getAccount());
        accountRepository.save(professional.getAccount());
        professionalRepository.save(professional);
    }

    @GetMapping(value = "/getProfessionals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Professional>> getListProfessional()
    {
    	List<Professional> l = professionalRepository.findAll();
        System.out.println(l);
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
