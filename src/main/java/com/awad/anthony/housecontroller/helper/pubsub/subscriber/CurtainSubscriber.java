package com.awad.anthony.housecontroller.helper.pubsub.subscriber;

import com.awad.anthony.housecontroller.helper.pubsub.Message;

public class CurtainSubscriber extends Subscriber{

	@Override
	public boolean doWork(Message message) {
		if(message.getTopic().equalsIgnoreCase("open")) {
			return this.open();
		}else if(message.getTopic().equalsIgnoreCase("close")) {
			return this.close();
		}
		return false;
	}
	
	private boolean open() {
		System.out.println("open curtain");
		return false;
		
	}
	
	private boolean close() {
		System.out.println("close curtain");
		return false;
		
	}


}
