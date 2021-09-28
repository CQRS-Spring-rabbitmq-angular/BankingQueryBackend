package com.hatmani.CQRS.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hatmani.CQRS.entity.DTO.operationDTO;
import com.hatmani.bankingEvent.*;



@Entity
public class Account {
	@Id 
private String id;
private BigDecimal Balance;
private String Currency;
@Enumerated(EnumType.STRING)
private StatusAcount Status;
private String proprietaire;
private Date dateCreation;
public Account() {
	super();
	// TODO Auto-generated constructor stub
}

public Account(String id, BigDecimal balance, String currency, StatusAcount status,String proprietaire,Date dateCreation) {
	super();
	this.id = id;
	Balance = balance;
	Currency = currency;
	Status = status;
	this.proprietaire=proprietaire;
	this.dateCreation=dateCreation;
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

public String getProprietaire() {
	return proprietaire;
}

public void setProprietaire(String proprietaire) {
	this.proprietaire = proprietaire;
}

public Date getDateCreation() {
	return dateCreation;
}

public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}


}

