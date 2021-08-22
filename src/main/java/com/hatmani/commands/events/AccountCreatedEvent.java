package com.hatmani.commands.events;

import java.math.BigDecimal;

import com.hatmani.CQRS.entity.StatusAcount;




public class AccountCreatedEvent extends BaseEvent<String> {
private BigDecimal initialAccount;
private String Currency;
private StatusAcount status;
/**
 * @param id
 * @param initialAccount
 * @param currency
 * @param status
 */
public AccountCreatedEvent(String id, BigDecimal initialAccount, String currency, StatusAcount status) {
	super(id);
	this.initialAccount = initialAccount;
	Currency = currency;
	this.status = status;
}
public BigDecimal getInitialAccount() {
	return initialAccount;
}
public void setInitialAccount(BigDecimal initialAccount) {
	this.initialAccount = initialAccount;
}
public String getCurrency() {
	return Currency;
}
public void setCurrency(String currency) {
	Currency = currency;
}
public StatusAcount getStatus() {
	return status;
}
public void setStatus(StatusAcount status) {
	this.status = status;
}
@Override
public String toString() {
	return super.toString()+ "AccountCreatedEvent [initialAccount=" + initialAccount + ", Currency=" + Currency + ", status=" + status
			+ "]";
}
	
}
