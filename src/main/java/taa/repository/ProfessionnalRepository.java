package taa.repository;

import taa.entity.Professionnal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProfessionnalRepository extends JpaRepository<Professionnal, Long>
{



}
