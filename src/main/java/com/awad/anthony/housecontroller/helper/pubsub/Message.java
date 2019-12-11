package com.awad.anthony.housecontroller.helper.pubsub;

public class Message {
	private String topic;

	public Message(String topic) {
		super();
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
