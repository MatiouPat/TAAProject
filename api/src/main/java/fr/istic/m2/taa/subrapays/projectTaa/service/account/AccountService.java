package fr.istic.m2.taa.subrapays.projectTaa.service.account;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.service.account.impl.ServiceResponse;

public interface AccountService
{

    ServiceResponse login(Account requestAccount);

}
