package com.awad.anthony.housecontroller.helper.pubsub.publisher;

import com.awad.anthony.housecontroller.helper.pubsub.Message;

public abstract class Publisher {
	private Message message;

	public Publisher(Message message) {
		super();
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	
}
