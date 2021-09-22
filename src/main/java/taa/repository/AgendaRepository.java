package taa.repository;

import taa.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AgendaRepository extends JpaRepository<Long, Agenda>
{

}
