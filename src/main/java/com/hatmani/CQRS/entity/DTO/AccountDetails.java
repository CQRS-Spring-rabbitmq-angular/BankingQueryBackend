package com.hatmani.CQRS.entity.DTO;

import java.util.ArrayList;
import java.util.List;

import com.hatmani.CQRS.entity.Account;
import com.hatmani.CQRS.entity.Operation;

public class AccountDetails {
public  Account account;// = new Account();
public  List<Operation> operations;// = null;
public AccountDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public AccountDetails(Account account, List<Operation> operations) {
	super();
	this.account = new Account();
	this.account =account;
	this.operations = new ArrayList<Operation>();
	this.operations=operations;
}

}
