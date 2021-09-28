package com.hatmani.CQRS.entity.DTO;

import java.math.BigDecimal;
import java.util.Date;



import com.hatmani.CQRS.entity.operationtype;

public class operationDTO {
public Long Id;
public operationtype Typeoperation;
public BigDecimal Amount;
public Date Dateoperation;
public operationDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public operationDTO(Long id, operationtype typeoperation, BigDecimal amount, Date dateoperation) {
	super();
	Id = id;
	Typeoperation = typeoperation;
	Amount = amount;
	Dateoperation = dateoperation;
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

}
