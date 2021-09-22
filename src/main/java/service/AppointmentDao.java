package service;

import domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AppointmentDao extends JpaRepository<Long, Appointment>
{
}
