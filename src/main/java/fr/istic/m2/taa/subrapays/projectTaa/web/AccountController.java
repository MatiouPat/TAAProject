package fr.istic.m2.taa.subrapays.projectTaa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.istic.m2.taa.subrapays.projectTaa.entity.Account;
import fr.istic.m2.taa.subrapays.projectTaa.entity.Professionnal;
import fr.istic.m2.taa.subrapays.projectTaa.repository.AccountRepository;

@Controller
public class AccountController {

	private AccountRepository accountRepository;

	
	@Autowired
	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}



	@RequestMapping("/create")
	public void create(@RequestParam String login, @RequestParam String mdp,
			@RequestParam String nom, @RequestParam String prenom,@RequestParam String job) {
		Account a=new Account();
		Professionnal p=new Professionnal();
		try {
			a.setLogin(login);
			a.setPassword(mdp);
			p.setFirstname(prenom);
			p.setLastname(nom);
			p.setJob(job);
			a.setProfessionnal(p);
			accountRepository.save(a);
		}catch(Exception e){e.printStackTrace();}
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestParam Long id) {
		accountRepository.deleteById(id);
	}
}
