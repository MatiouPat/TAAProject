package fr.istic.m2.taa.subrapays.projectTaa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.istic.m2.taa.subrapays.projectTaa.dto.AgendaDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Agenda;

@Mapper
public interface AgendaMapper {
	
	AgendaMapper INSTANCE=Mappers.getMapper(AgendaMapper.class);
	
	Agenda agendaDtoToAgenda(AgendaDto agDto);
	AgendaDto agendaToDto(Agenda ag);
}
