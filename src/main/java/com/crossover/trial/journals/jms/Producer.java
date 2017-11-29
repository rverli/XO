package com.crossover.trial.journals.jms;

import java.io.IOException;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.crossover.trial.journals.dto.EmailDTO;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Producer implements CommandLineRunner {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	@Override
	public void run(String... args) throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		EmailDTO e1 = new EmailDTO("teste@teste.com", "body email");
		
		String jsonInString = null;
		
		try {
			//Convert object to JSON string and pretty print
			jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString( e1 );
			System.out.println(jsonInString);

			// Convert JSON string to Object
			EmailDTO user1 = objectMapper.readValue(jsonInString, EmailDTO.class);
			System.out.println(user1);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		send(jsonInString);
		System.out.println("Message was sent to the Queue");
	}

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

}