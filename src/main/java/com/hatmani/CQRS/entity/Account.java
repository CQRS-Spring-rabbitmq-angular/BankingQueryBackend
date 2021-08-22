package com.hatmani.CQRS.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.hatmani.bankingEvent.*;



@Entity
public class Account {
	@Id 
private String id;
private BigDecimal Balance;
private String Currency;
@Enumerated(EnumType.STRING)
private StatusAcount Status;

public Account() {
	super();
	// TODO Auto-generated constructor stub
}

public Account(String id, BigDecimal balance, String currency, StatusAcount status) {
	super();
	this.id = id;
	Balance = balance;
	Currency = currency;
	Status = status;
}

@Override
public String toString() {
	return "Account [id=" + id + ", Balance=" + Balance + ", Currency=" + Currency + ", Status=" + Status + "]";
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public BigDecimal getBalance() {
	return Balance;
}

public void setBalance(BigDecimal balance) {
	Balance = balance;
}

public String getCurrency() {
	return Currency;
}

public void setCurrency(String currency) {
	Currency = currency;
}

public StatusAcount getStatus() {
	return Status;
}

public void setStatus(StatusAcount status) {
	Status = status;
}


}

