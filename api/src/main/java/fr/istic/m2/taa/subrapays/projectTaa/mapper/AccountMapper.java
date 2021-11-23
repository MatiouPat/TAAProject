package fr.istic.m2.taa.subrapays.projectTaa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.istic.m2.taa.subrapays.projectTaa.dto.AccountDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;

@Mapper
public interface AccountMapper {
	
	AccountMapper INSTANCE=Mappers.getMapper(AccountMapper.class);
	
	AccountDto accountToDto(Account a);
	Account dtoToAccount(AccountDto acDto);
}
