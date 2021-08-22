package com.hatmani.CQRS.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Operation {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;
@Enumerated(EnumType.STRING)
private operationtype Typeoperation;
private BigDecimal Amount;
private Date Dateoperation;
@ManyToOne
private Account acount;
public Operation() {
	super();
	// TODO Auto-generated constructor stub
}
public Operation(Long id, operationtype typeoperation, BigDecimal amount, Date dateoperation, Account acount) {
	super();
	Id = id;
	Typeoperation = typeoperation;
	Amount = amount;
	Dateoperation = dateoperation;
	this.acount = acount;
}
@Override
public String toString() {
	return "Operation [Id=" + Id + ", Typeoperation=" + Typeoperation + ", Amount=" + Amount + ", Dateoperation="
			+ Dateoperation + ", acount=" + acount + "]";
}
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public operationtype getTypeoperation() {
	return Typeoperation;
}
public void setTypeoperation(operationtype typeoperation) {
	Typeoperation = typeoperation;
}
public BigDecimal getAmount() {
	return Amount;
}
public void setAmount(BigDecimal amount) {
	Amount = amount;
}
public Date getDateoperation() {
	return Dateoperation;
}
public void setDateoperation(Date dateoperation) {
	Dateoperation = dateoperation;
}
public Account getAcount() {
	return acount;
}
public void setAcount(Account acount) {
	this.acount = acount;
}

}
