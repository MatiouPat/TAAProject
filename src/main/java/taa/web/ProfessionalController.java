package taa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import taa.entity.Appointment;
import taa.entity.Professional;
import taa.repository.AppointmentRepository;
import taa.repository.ProfessionalRepository;

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
