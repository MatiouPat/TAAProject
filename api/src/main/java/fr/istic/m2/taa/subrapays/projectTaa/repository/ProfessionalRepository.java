package fr.istic.m2.taa.subrapays.projectTaa.repository;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long>
{
	
	@Query("select p from Professional as p where p.firstname=?1 and p.lastname=?2")
	public Professional FindProfessionnalByName(String firstname,String lastname);
	
	@Query("select p from Professional as p where p.job=?1")
	public List<Professional> FindAllProfessionnalByJob(String job);
	
	
}
