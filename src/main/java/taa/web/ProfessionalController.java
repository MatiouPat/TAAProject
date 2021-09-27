package taa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import taa.entity.Appointment;
import taa.entity.Professionnal;
import taa.repository.AppointmentRepository;
import taa.repository.ProfessionnalRepository;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class ProfessionalController
{

    private ProfessionnalRepository professionalRepository;

    @Autowired
    public void setAppointmentDao(ProfessionnalRepository professionalRepository)
    {
        this.professionalRepository = professionalRepository;
    }

    @RequestMapping("/professional/create")
    @ResponseBody
    public String create()
    {
        Professionnal professionnal = new Professionnal();
        try {
            professionalRepository.save(professionnal);
        }catch (Exception e) {
            return "Error creating the professional: " + e.toString();
        }
        return "Professional successfully created with id = " + professionnal.getId().toString();
    }

    @RequestMapping("/professional/{id}")
    @ResponseBody
    public String read(@PathVariable long id)
    {
        Professionnal p = null;
        try {
            p = professionalRepository.getById(id);
        }catch (Exception e) {
            return "Error reading the professional: " + e.toString();
        }
        return "Professional successfully read " + p.getFirstname() + p.getLastname();
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
