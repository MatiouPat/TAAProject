package fr.istic.m2.taa.subrapays.projectTaa.repository;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>
{
	
	@Query("select a from Appointment as a where a.professionnal.firstname=?1 and a.professionnal.firstname=?2")
	public Agenda FindAgendaByProfessionnal(String firstname, String lastname);
	
}
