package fr.istic.m2.taa.subrapays.projectTaa.service.security;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailService implements UserDetailsService
{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByLogin(username);
        if (account != null){
            return account;
        }
        throw new UsernameNotFoundException("Account '" + account + "' not found");
    }

}
