package com.hatmani.CQRS.services.projection;

import java.util.Date;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import com.hatmani.CQRS.entity.*;

import com.hatmani.CQRS.services.AccountService;
import com.hatmani.commands.events.*;



@Component
@ProcessingGroup(value = "amqpEvents")
public class AccountprojecteventHandler {
@Autowired 
AccountService accountservice;


public AccountprojecteventHandler(AccountService accountservice) {
	super();
	this.accountservice = accountservice;
	System.out.println("======>Account handler projection service Start");
	
	
}
public AccountprojecteventHandler() {
	// TODO Auto-generated constructor stub
}
/**
 * 
 */
//@ProcessingGroup(value = "amqpEvents")
@EventHandler
public void on(AccountCreatedEvent event)
{
	System.out.println("*************************");
	System.out.println("* ACCOUNT CREATED EVENT *");
	System.out.println("*************************");
	System.out.println("event"+event.toString());
	System.out.println("*************************");
	System.out.println("id "+event.getId());
	System.out.println("InitialAccount "+event.getInitialAccount());
	System.out.println("Currency "+event.getCurrency());
	System.out.println("Status "+event.getStatus());
	if(!event.getId().isEmpty()) {
		Account account = new Account(event.getId(),event.getInitialAccount(),event.getCurrency(),StatusAcount.INACTIVE);
		System.out.println("account "+account.toString());
		
		accountservice.SaveAccount(account);
		System.out.println("account "+event.toString()+" was inserted");
	}else
	{
		System.out.println("!!!!! account "+event.toString()+" empty not inserted");
	}
	
}
@EventHandler
public void on(AccountActivetedEvent event)
{System.out.println("*************************");
System.out.println("ACCOUNT ACTIVATED EVENT");
System.out.println("*************************");
	Account account = accountservice.FindAccountByAccountId(event.getId());
	account.setStatus(event.getStatus());
	accountservice.SaveAccount(account);
}
@EventHandler
@Transactional
public void on(AccountCreditedEvent event)
{System.out.println("*************************");
System.out.println("ACCOUNT CREDITED EVENT");
System.out.println("*************************");
	Account account =accountservice.FindAccountByAccountId(event.getId());
	account.setBalance(account.getBalance().add(event.getAmount()));
	accountservice.SaveAccount(account);
	
	Operation operation = new Operation(null, operationtype.CREDIT,event.getAmount(),new Date(), account);
	accountservice.SaveOperation(operation);
}
@EventHandler
@Transactional
public void on(AccountDebitedEvent event)
{
	System.out.println("*************************");
	System.out.println("ACCOUNT DEBITED EVENT");
	System.out.println("*************************");
	Account account =accountservice.FindAccountByAccountId(event.getId());
	account.setBalance(account.getBalance().subtract(event.getAmount()));
	accountservice.SaveAccount(account);
	
	Operation operation = new Operation(null, operationtype.DEBIT,event.getAmount(),new Date(), account);
	accountservice.SaveOperation(operation);
}

}
