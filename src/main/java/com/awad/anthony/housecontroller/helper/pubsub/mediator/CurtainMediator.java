package com.awad.anthony.housecontroller.helper.pubsub.mediator;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awad.anthony.housecontroller.helper.pubsub.Message;
import com.awad.anthony.housecontroller.helper.pubsub.publisher.Publisher;
import com.awad.anthony.housecontroller.helper.pubsub.subscriber.Subscriber;

@Service("curtainMediator")
@Transactional
public class CurtainMediator extends Mediator{
	
	public CurtainMediator() {
		//additional curain configuration
		this.queue = new ArrayList<Message>();

		System.out.println("inside curtain mediator created");
	}
	
	@Override
	public boolean publish(Publisher publisher) {
		this.queue.add(publisher.getMessage());

		System.out.println("inside curtain mediator publisher added");
		return false;
	}

	@Override
	public boolean addSubcriber(Subscriber subscriber) {
		this.subscriber = subscriber;
		System.out.println("inside curtain mediator subscriber added");
		return false;
	}
	@Override
	public void initialize() {
		try {
			 this.thread = new Thread(this);
			thread.start();
			System.out.println("inside curtain mediator initialed thread");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void run() {
		System.out.println("inside curtain mediator run method");
		while(true) {
			synchronized(new Object()){
				if(queue.size()>0) {
					Message message = queue.get(queue.size()-1);
					queue.remove(queue.size()-1);
					this.subscriber.doWork(message);
				}
			}
			
		}
		
	}

	
	

}
