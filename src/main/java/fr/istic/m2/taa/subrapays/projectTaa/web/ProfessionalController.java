package fr.istic.m2.taa.subrapays.projectTaa.web;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

public class ProfessionalController
{

    private ProfessionalRepository professionalRepository;

    @Autowired
    public void setAppointmentDao(ProfessionalRepository professionalRepository)
    {
        this.professionalRepository = professionalRepository;
    }

    @RequestMapping("/professional/create")
    @ResponseBody
    public String create()
    {
        String professionalId = "";
        try {
            Professional professional = new Professional();
            professionalRepository.save(professional);
            professionalId = String.valueOf(professional.getId());
        }catch (Exception e) {
            return "Error creating the professional: " + e.toString();
        }
        return "Professional successfully created with id = " + professionalId;
    }

    @RequestMapping("/professional/{id}")
    @ResponseBody
    public String read(@PathVariable String id)
    {
        Professional professional = null;
        try {
            professional = professionalRepository.getById(Long.valueOf(id));
        }catch (Exception e) {
            return "Error reading the professional: " + e.toString();
        }
        return "Professional successfully read " + professional.getFirstname() + professional.getLastname();
    }

    @PostMapping("/professional/update/{id}")
    public String update(@RequestBody Professional professional)
    {

        return "Professional successfully deleted with id = ";
    }

    @RequestMapping("/professional/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable String id)
    {
        String professionalId = "";
        try {
            Professional professional = professionalRepository.getById(Long.valueOf(id));
            professionalId = String.valueOf(professional.getId());
            professionalRepository.delete(professional);
        }catch (Exception e){
            return "Error deleting the professional: " + e.toString();
        }
        return "Professional successfully deleted with id = " + professionalId;
    }

}
