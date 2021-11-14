package fr.istic.m2.taa.subrapays.projectTaa.repository;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>
{

	@Query("select a from Appointment as a")
	public List<Appointment> FindAllAppointment();
	
	@Query("select a from Appointment as a where a.professional.firstname=?1 and a.professional.lastname=?2")
	public List<Appointment> FindAllAppointmentByProfessionnal(String firstname,String lastname);
	
	@Query("select a from Appointment as a where a.user.firstname=?1 and a.user.lastname=?2")
	public List<Appointment> FindAllAppointmentByUser(String firstname,String lastname);
		
	@Query("select a from Appointment as a where a.professional.firstname=?1 and a.professional.lastname=?2 and a.user.firstname=?3 and a.user.lastname=?4")
	public Appointment FindAppointmentByUserAndProfesionnal(String pfirstname,String plastname,String ufirstname,String ulastname);
}
