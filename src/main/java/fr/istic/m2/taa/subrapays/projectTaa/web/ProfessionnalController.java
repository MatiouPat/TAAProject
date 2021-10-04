package fr.istic.m2.taa.subrapays.projectTaa.web;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Professionnal;
import fr.istic.m2.taa.subrapays.projectTaa.repository.ProfessionnalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class ProfessionnalController
{

    private ProfessionnalRepository professionnalRepository;

    @Autowired
    public void setAppointmentDao(ProfessionnalRepository professionnalRepository)
    {
        this.professionnalRepository = professionnalRepository;
    }

    @RequestMapping("/professional/create")
    @ResponseBody
    public String create()
    {
        Professionnal professionnal = new Professionnal();
        try {
            professionnalRepository.save(professionnal);
        }catch (Exception e) {
            return "Error creating the professional: " + e.getStackTrace();
        }
        return "Professional successfully created with id = " + professionnal.getId().toString();
    }

    @RequestMapping("/professionnal/{id}")
    @ResponseBody
    public String read(@PathVariable long id)
    {
        Professionnal professionnal = null;
        try {
            professionnal = professionnalRepository.getById(id);
        }catch (Exception e) {
            return "Error reading the professional: " + e.getStackTrace();
        }
        return "Professional successfully read " + professionnal.getFirstname()+" "+ professionnal.getLastname()+" "+professionnal.getJob();
    }


    @RequestMapping("/professional/delete/{id}")
    @ResponseBody
    public String deleteById(@PathVariable long id)
    {
        try {
            professionnalRepository.deleteById(id);
        }catch (Exception e){
            return "Error deleting the professional: " + e.getStackTrace();
        }
        return "Professional with id="+id+" successfully deleted";
    }

}
