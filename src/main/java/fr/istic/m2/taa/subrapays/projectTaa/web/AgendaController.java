package fr.istic.m2.taa.subrapays.projectTaa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Agenda;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Appointment;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AgendaRepository;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AppointmentRepository;

@Controller
public class AgendaController {

	private AgendaRepository agendaRepository;
	private AppointmentRepository appointmentRepository;

	@Autowired
	public AgendaController(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}


	@RequestMapping("/agenda")
	public void getAgenda(@RequestParam String nom, @RequestParam String prenom){
		Agenda a=new Agenda();
		List<Appointment> l=appointmentRepository.findAll();
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
