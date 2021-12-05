package fr.istic.m2.taa.subrapays.projectTaa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.istic.m2.taa.subrapays.projectTaa.dto.ProfessionalDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper {
	
	ProfessionalMapper INSTANCE=Mappers.getMapper(ProfessionalMapper.class);
	
	ProfessionalDto professionalDtoProfessionalDto(Professional p);	
	Professional professionalDtoToProfessional(ProfessionalDto p);


}
