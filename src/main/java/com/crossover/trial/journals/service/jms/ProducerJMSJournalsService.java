package com.crossover.trial.journals.service.jms;

import javax.jms.Queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerJMSJournalsService {

	private final static Logger log = Logger.getLogger(ProducerJMSJournalsService.class);
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	public void send( String msg ) {
		
		this.jmsMessagingTemplate.convertAndSend( this.queue, msg );
		
		log.info("Message was sent to the Queue: " + msg);
	}
}