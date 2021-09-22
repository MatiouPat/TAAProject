package service;

import domain.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AgendaDao extends JpaRepository<Long, Agenda>
{

}
