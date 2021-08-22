package com.hatmani.CQRS.services;

import java.util.List;

import com.hatmani.CQRS.entity.*;



public interface IAccountService {
	List<Account> FindAllAccount();
	List<Operation> FindOperationByAccountId(String AccountId);
	Account FindAccountByAccountId(String AccountId);
	Account SaveAccount(Account account);
	Operation SaveOperation(Operation operation);
	}

