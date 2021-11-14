package fr.istic.m2.taa.subrapays.projectTaa.controller;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Appointment;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/Appointment")
public class AppointmentController{

    private AppointmentRepository appointmentRepository;

    @Autowired
    public void setAppointmentRepository(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping(value="/get")
    @ResponseBody
    public Appointment getAppointment(@PathVariable String pnom, @PathVariable String pprenom, @PathVariable String unom, @PathVariable String uprenom) {
    	Appointment a=null;
    	try {
    		a=appointmentRepository.FindAppointmentByUserAndProfesionnal(pprenom, pnom, uprenom, unom);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return a;
    }
}
