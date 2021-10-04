package fr.istic.m2.taa.subrapays.projectTaa.web;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Appointment;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppointmentController{

    private AppointmentRepository appointmentRepository;

    @Autowired
    public void setAppointmentDao(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @RequestMapping("/appointment/create")
    @ResponseBody
    public String create(){
        String appointmentId = "";
        try {
            Appointment appointment = new Appointment();
            appointmentRepository.save(appointment);
            appointmentId = String.valueOf(appointment.getId());
        }catch (Exception e) {
            return "Error creating the appointment: " + e.getStackTrace();
        }
        return "Appointment succesfully created with id = " + appointmentId;
    }

    
    @RequestMapping("/delete")
    public void delete(@PathVariable Long id) {
    	try {
    		appointmentRepository.deleteById(id);
    	} catch(Exception e) {
    		
    	}
    }
}
