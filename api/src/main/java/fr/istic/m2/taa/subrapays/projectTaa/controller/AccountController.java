package fr.istic.m2.taa.subrapays.projectTaa.controller;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professional;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AccountRepository;

@Controller
@RequestMapping("/Account")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private EntityManager em;
	
	@Autowired
	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}



	@PostMapping(value="/create",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> create(@PathVariable String login, @PathVariable String mdp,
			@PathVariable String nom, @PathVariable String prenom,@PathVariable String job) {
		Account a=new Account();
		Professional p=new Professional();
		try {
			a.setLogin(login);
			a.setPassword(mdp);
			p.setFirstname(prenom);
			p.setLastname(nom);
			p.setJob(job);
			a.setProfessional(p);
			accountRepository.save(a);
		}catch(Exception e){e.printStackTrace();}
		return ResponseEntity.status(HttpStatus.OK).body(a);
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
