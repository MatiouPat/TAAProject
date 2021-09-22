package taa.repository;

import taa.entity.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProfessionalRepository extends JpaRepository<Long, Professional>
{

}
