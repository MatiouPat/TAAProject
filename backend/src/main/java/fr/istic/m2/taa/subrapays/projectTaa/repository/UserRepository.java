package fr.istic.m2.taa.subrapays.projectTaa.repository;

import fr.istic.m2.taa.subrapays.projectTaa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

	@Query("select u from User as u where u.lastname=?1")
	public User FindUserByLastname(String lastname);
	
	@Query("select u from User as u where u.firstname=?1")
	public User FindUserByFirstname(String firstname);	
	
}
