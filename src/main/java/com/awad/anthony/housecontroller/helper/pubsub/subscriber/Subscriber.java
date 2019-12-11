package com.awad.anthony.housecontroller.helper.pubsub.subscriber;

import com.awad.anthony.housecontroller.helper.pubsub.Message;

public abstract class Subscriber{
	protected Thread thread;
	public  abstract boolean doWork(Message message);

}
