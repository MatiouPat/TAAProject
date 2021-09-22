package service;

import domain.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProfessionalDao extends JpaRepository<Long, Professional>
{

}
