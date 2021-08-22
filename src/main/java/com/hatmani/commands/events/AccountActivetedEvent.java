package com.hatmani.commands.events;

import com.hatmani.CQRS.entity.StatusAcount;

public class AccountActivetedEvent extends BaseEvent<String>{
private StatusAcount status;

/**
 * @param id
 * @param status
 */
public AccountActivetedEvent(String id, StatusAcount status) {
	super(id);
	this.status = status;
}

public StatusAcount getStatus() {
	return status;
}

public void setStatus(StatusAcount status) {
	this.status = status;
}

	
}
