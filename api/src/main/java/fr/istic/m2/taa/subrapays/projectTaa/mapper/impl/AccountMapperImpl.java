package fr.istic.m2.taa.subrapays.projectTaa.mapper.impl;

import fr.istic.m2.taa.subrapays.projectTaa.dto.AccountDto;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.mapper.AccountMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper
{

    @Override
    public AccountDto accountToDto(Account a) {
        AccountDto accountDto = new AccountDto();
        accountDto.setLogin(a.getLogin());
        accountDto.setPassword(a.getPassword());
        return accountDto;
    }

    @Override
    public Account dtoToAccount(AccountDto accountDto) {
        if (accountDto == null){
            return null;
        }

        Account account = new Account();

        account.setLogin(accountDto.getLogin());
        account.setPassword(accountDto.getPassword());

        return account;
    }
}
