package fr.istic.m2.taa.subrapays.projectTaa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Agenda;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Appointment;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AgendaRepository;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AppointmentRepository;

@Controller
@RequestMapping("/Agenda")
public class AgendaController {

	private AgendaRepository agendaRepository;
	private AppointmentRepository appointmentRepository;

	@Autowired
	public void setAgendaRepository(AgendaRepository agendaRepository)
	{
		this.agendaRepository = agendaRepository;
	}

	@Autowired
	public void setAppointmentRepository(AppointmentRepository appointmentRepository)
	{
		this.appointmentRepository = appointmentRepository;
	}

	@GetMapping(value="/get/{id}")
	@ResponseBody
	public Agenda getAgenda(@PathVariable String nom, @PathVariable String prenom){
		Agenda a=new Agenda();
		try {
			Collection<Appointment> c=appointmentRepository.FindAllAppointmentByProfessionnal(prenom, nom);
			a.setAppointments(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
}
