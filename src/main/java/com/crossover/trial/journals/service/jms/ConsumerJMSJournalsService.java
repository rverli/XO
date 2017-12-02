package com.crossover.trial.journals.service.jms;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.crossover.trial.journals.dto.EmailDTO;
import com.crossover.trial.journals.service.email.SenderMailService;
import com.crossover.trial.journals.util.JsonUtil;
import com.crossover.trial.journals.util.exception.ServiceException;

@Service
public class ConsumerJMSJournalsService {

	private final static Logger log = Logger.getLogger( ConsumerJMSJournalsService.class );
	
	@Autowired
	private SenderMailService senderMailService;
	
	@JmsListener(destination = "journals.queue")
	public void receiveQueue( String text ) throws ServiceException {
		
		try {
			EmailDTO email = JsonUtil.jsonToEmailDTO( text );
			
			senderMailService.enviar( email );
			
			log.info( "Email sent to: " + email.getTo());
		} catch (Exception e) {
			log.error( e.getMessage() );
			throw new ServiceException( "Error trying send email", e );
		}
	}
}
