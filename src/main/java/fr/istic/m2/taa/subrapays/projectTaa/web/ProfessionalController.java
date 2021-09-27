package fr.istic.m2.taa.subrapays.projectTaa.web;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
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
        Professional professional = new Professional();
        try {
            professionalRepository.save(professional);
        }catch (Exception e) {
            return "Error creating the professional: " + e.toString();
        }
        return "Professional successfully created with id = " + professional.getId().toString();
    }

    @RequestMapping("/professional/{id}")
    @ResponseBody
    public String read(@PathVariable long id)
    {
        Professional professional = null;
        try {
            professional = professionalRepository.getById(id);
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
    public String delete(@PathVariable long id)
    {
        try {
            professionalRepository.deleteById(id);
        }catch (Exception e){
            return "Error deleting the professional: " + e.toString();
        }
        return "Professional successfully deleted with id = " + id;
    }

}
