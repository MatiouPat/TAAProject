package fr.istic.m2.taa.subrapays.projectTaa.controller;

import javax.persistence.EntityManager;

import fr.istic.m2.taa.subrapays.projectTaa.dto.AccountDto;
import fr.istic.m2.taa.subrapays.projectTaa.mapper.AccountMapper;
import fr.istic.m2.taa.subrapays.projectTaa.service.account.AccountService;
import fr.istic.m2.taa.subrapays.projectTaa.service.account.impl.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AccountRepository;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	private final AccountMapper mapper;

	private final AccountRepository accountRepository;

	private final EntityManager em;

	public AccountController(AccountMapper mapper, AccountRepository accountRepository, EntityManager em) {
		this.mapper = mapper;
		this.accountRepository = accountRepository;
		this.em = em;
	}

	@PostMapping(value="/login")
	@ResponseBody
	public ServiceResponse login(@RequestBody AccountDto accountDto)
	{
		Account account = mapper.dtoToAccount(accountDto);
		ServiceResponse response = accountService.login(account);
		return response;
	}

	@PostMapping(value="/create",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> create(@RequestBody AccountDto accountDto) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@DeleteMapping(value="/delete/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Account> delete(@PathVariable Long id) {
		try {
			accountRepository.deleteById(id);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PutMapping(value="/update/{id}")
	@ResponseBody
	public ResponseEntity<Account> update(@PathVariable Long id,@PathVariable String Login,@PathVariable String Password){
		Account a=null;
		try {
			a=accountRepository.getById(id);
			a.setLogin(Login);
			a.setPassword(Password);
			accountRepository.save(a);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
