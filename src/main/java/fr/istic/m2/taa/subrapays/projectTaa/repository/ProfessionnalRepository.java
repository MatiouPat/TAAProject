package fr.istic.m2.taa.subrapays.projectTaa.repository;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Professionnal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProfessionnalRepository extends JpaRepository<Professionnal, Long>{}
