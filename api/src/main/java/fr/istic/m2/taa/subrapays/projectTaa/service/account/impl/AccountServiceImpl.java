package fr.istic.m2.taa.subrapays.projectTaa.service.account.impl;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{

    private static final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class.getName());

    AuthenticationManager authenticationManager;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ServiceResponse login(Account requestAccount) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(requestAccount.getLogin(), requestAccount.getPassword());
        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            Account account = (Account) authentication.getPrincipal();
            LOGGER.info("Logged with account: {" + account + "}");

            return new ServiceResponse(HttpStatus.OK, MsgServiceResponse.NO_USER_WITH_USERNAME);
        } catch (BadCredentialsException ex) {
            return new ServiceResponse(HttpStatus.BAD_REQUEST, MsgServiceResponse.NO_USER_WITH_USERNAME);
        }
    }

}
