package fr.istic.m2.taa.subrapays.projectTaa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.istic.m2.taa.subrapays.projectTaa.dto.UserDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
	
	UserDto userToUserDto(User u);
	User userDtoToUser(UserDto uDto);
}
