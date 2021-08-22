package com.hatmani.CQRS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hatmani.CQRS.entity.*;
import com.hatmani.CQRS.repository.AccountRepository;
import com.hatmani.CQRS.repository.OperationRepository;


@Service
public class AccountService implements IAccountService{
	@Autowired
	AccountRepository accountrepository;
	@Autowired
	OperationRepository operationrepository;
		@Override
		public List<Account> FindAllAccount() {
			// TODO Auto-generated method stub
			return accountrepository.findAll();
		}

		@Override
		public List<Operation> FindOperationByAccountId(String AccountId) {
			// TODO Auto-generated method stub
			return operationrepository.findAllByAcountId(AccountId);
		}

		@Override
		public Account FindAccountByAccountId(String AccountId) {
			// TODO Auto-generated method stub
			return accountrepository.findById(AccountId).orElse(null);
		}

		@Override
		public Account SaveAccount(Account account) {
			// TODO Auto-generated method stub
			return accountrepository.save(account);
		}

		@Override
		public Operation SaveOperation( Operation operation) {
			
			return operationrepository.save(operation);
			
			
		}

	}
