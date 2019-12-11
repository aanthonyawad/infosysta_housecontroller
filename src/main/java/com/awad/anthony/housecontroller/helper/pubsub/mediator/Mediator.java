package com.awad.anthony.housecontroller.helper.pubsub.mediator;

import java.util.ArrayList;
import java.util.List;

import com.awad.anthony.housecontroller.helper.pubsub.Message;
import com.awad.anthony.housecontroller.helper.pubsub.publisher.Publisher;
import com.awad.anthony.housecontroller.helper.pubsub.subscriber.Subscriber;

public abstract class Mediator implements Runnable{
	protected List<Message> queue;
	protected Subscriber subscriber;
	protected Thread thread;
	public abstract boolean publish(Publisher publisher);
	public abstract boolean addSubcriber(Subscriber subscriber);
	

	public abstract void initialize();
}
