package com.hatmani.CQRS.Controllers;

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
@CrossOrigin("*")
@RestController
@RequestMapping("/Api/v1")
public class BankingController {
	@Autowired
	AccountService _accountService;
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
 
}
