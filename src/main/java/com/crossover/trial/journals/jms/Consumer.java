package com.crossover.trial.journals.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "journals.queue")
	public void receiveQueue(String text) {
		System.out.println(text);
	}

}
