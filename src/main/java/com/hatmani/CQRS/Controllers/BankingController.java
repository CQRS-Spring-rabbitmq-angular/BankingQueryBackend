package com.hatmani.CQRS.Controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hatmani.CQRS.entity.Account;
import com.hatmani.CQRS.entity.Operation;
import com.hatmani.CQRS.entity.DTO.AccountDetails;
import com.hatmani.CQRS.entity.DTO.operationDTO;
import com.hatmani.CQRS.services.AccountService;
import com.hatmani.bankingEvent.StatusAcount;
import com.hatmani.CQRS.repository.AccountdommyRepository;
import com.hatmani.CQRS.entity.Accountdommy;
@CrossOrigin("*")
@RestController
@RequestMapping("/Api/v1")
public class BankingController {
	@Autowired
	AccountService _accountService;
	@Autowired
	AccountdommyRepository accountdommyRepository;
/*@Autowired
public BankingController(AccountService accountService) {
	super();
	this._accountService = accountService;
}*/

@GetMapping("/AllAccount")
public ResponseEntity<List<Account>> getAllAccount()
{
	//try {
	return new ResponseEntity<List<Account>>(_accountService.FindAllAccount(),HttpStatus.OK);
	//} catch (Exception e) {
	//	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	//}
}
@GetMapping("/Account/{id}")
public ResponseEntity<AccountDetails> getAccountById(@PathVariable("id")String id)
{
	System.out.println("account details");
	try {
		Account account = _accountService.FindAccountByAccountId(id);
		System.out.println("account details"+account.toString());
		if (account==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		List<Operation> operations =_accountService.FindOperationByAccountId(id);
		AccountDetails accountDetails = new AccountDetails(account,operations);
		
		return new ResponseEntity<AccountDetails>(accountDetails,HttpStatus.OK);
	} catch (Exception e) {
		System.out.println(e);
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
@ExceptionHandler(Exception.class)
public ResponseEntity<String> senderrors(Exception exp)
{
	return new ResponseEntity<String>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
}
 
@GetMapping("/ping")
public ResponseEntity<List<Accountdommy>> pingAccount()
{
	//try {
/*	accountdommyRepository.save(new Accountdommy("FG210-1239-4567-002",new BigDecimal(2500),"EURO",StatusAcount.ACTIVE ,"Karim Hatmani" ));
	accountdommyRepository.save(new Accountdommy("FG210-5214-8496-951",new BigDecimal(3000),"EURO",StatusAcount.ACTIVE ,"Aymen Hatmani" ));
	accountdommyRepository.save(new Accountdommy("FG210-1239-9506-326",new BigDecimal(2000),"EURO",StatusAcount.ACTIVE ,"Helmi Hatmani" ));
	accountdommyRepository.save(new Accountdommy("FG210-4862-4568-202",new BigDecimal(2300),"EURO",StatusAcount.ACTIVE ,"Nouhe Hatmani" ));
	accountdommyRepository.save(new Accountdommy("FG210-4895-4568-916",new BigDecimal(1590),"EURO",StatusAcount.ACTIVE ,"Amel Hatmani" ));
	*/
	System.out.println("pinging .........");
	return new ResponseEntity<List<Accountdommy>>(accountdommyRepository.findAll(),HttpStatus.OK);
	//} catch (Exception e) {
	//	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	//}
}
}
