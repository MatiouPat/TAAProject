package fr.istic.m2.taa.subrapays.projectTaa.mapper.impl;

import fr.istic.m2.taa.subrapays.projectTaa.dto.ProfessionalDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.mapper.ProfessionalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalMapperImpl implements ProfessionalMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ProfessionalDto professionalDtoProfessionalDto(Professional p) {
        return null;
    }

    @Override
    public Professional professionalDtoToProfessional(ProfessionalDto p) {
        if (p == null){
            return null;
        }

        Professional professional = new Professional();
        Account account = new Account();

        professional.setJob(p.getJob());
        account.setLogin(p.getLogin());
        account.setPassword(passwordEncoder.encode(p.getPassword()));
        account.setProfessional(professional);
        professional.setAccount(account);


        return professional;
    }
}
