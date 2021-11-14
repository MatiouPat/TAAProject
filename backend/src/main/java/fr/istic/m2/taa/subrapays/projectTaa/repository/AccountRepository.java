package fr.istic.m2.taa.subrapays.projectTaa.repository;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{

	 @Query("select a from Account as a where a.professional.firstname=?1 and a.professional.lastname=?2")
	 public Account FindAccountByProfessionnal(String firstname, String lastname);
}
