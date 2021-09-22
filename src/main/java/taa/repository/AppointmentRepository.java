package taa.repository;

import taa.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>
{
}
