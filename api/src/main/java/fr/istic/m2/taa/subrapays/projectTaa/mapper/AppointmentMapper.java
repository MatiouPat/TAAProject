package fr.istic.m2.taa.subrapays.projectTaa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.istic.m2.taa.subrapays.projectTaa.dto.AppointmentDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Appointment;

@Mapper
public interface AppointmentMapper {
	
	AppointmentMapper INSTANCE=Mappers.getMapper(AppointmentMapper.class);
	
	Appointment appointmentDtoToAppointment(AppointmentDto apDto); 
	AppointmentDto appointmentToAppointmentDto(Appointment ap); 
}
