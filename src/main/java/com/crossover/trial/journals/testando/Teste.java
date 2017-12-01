package com.crossover.trial.journals.testando;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.crossover.trial.journals.dto.EmailDTO;
import com.crossover.trial.journals.service.jms.ProducerJMSJournalsService;
import com.crossover.trial.journals.util.JsonUtil;

@Component
public class Teste implements CommandLineRunner {

	private final static Logger log = Logger.getLogger(Teste.class);
	
	@Autowired
	private ProducerJMSJournalsService producer;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		log.info("Testando envio JMS");
		this.testeSendJMS();
	}

	private void testeSendJMS() throws Exception {
		
		EmailDTO email = new EmailDTO("fernandes.carloseduardo@gmail.com", "Teste Viadinho", "Viadinho", null);
		
		producer.send( JsonUtil.emailDTOToJson( email ) );
	}
}
