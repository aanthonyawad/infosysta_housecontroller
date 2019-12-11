package com.awad.anthony.housecontroller;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.awad.anthony.housecontroller.helper.pubsub.mediator.CurtainMediator;
import com.awad.anthony.housecontroller.helper.pubsub.subscriber.CurtainSubscriber;
import com.awad.anthony.housecontroller.helper.pubsub.subscriber.Subscriber;

@SpringBootApplication
public class Application {
	
	public static final CurtainMediator curtainMediator = new CurtainMediator();
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	
	@PostConstruct
	public void removeExpiredTokens() {
		Subscriber subscriber = new CurtainSubscriber();
		Application.curtainMediator.initialize();
		Application.curtainMediator.addSubcriber(subscriber);
	}
}
