package com.crossover.trial.journals.service.email;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.crossover.trial.journals.dto.EmailDTO;

@Component
public class SenderMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviar( EmailDTO emailDTO ) throws MessagingException {
    	
    	//Autorizacao para enviar email no google
    	//https://productforums.google.com/forum/#!topic/gmail-pt/EmEowutQ9Js
    	
        MimeMessage message = mailSender.createMimeMessage();
        
        // Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper( message, true );
        helper.setTo( emailDTO.getTo() );
        helper.setText( emailDTO.getBody() );
        helper.setSubject( emailDTO.getSubject() );
        
        List<Map<String, String>> atts = emailDTO.getAttachments();
        
        if ( atts != null && atts.size() > 0 ) {
			
        	for (Map<String, String> att : atts) {
        		
        		for ( Map.Entry<String, String> entry : att.entrySet()) {
        		    
        			String fileName = entry.getKey();
        		    String path = entry.getValue();
        		    
        		    ClassPathResource file = new ClassPathResource( path );
        		    helper.addAttachment( fileName, file );
        		}
			}
		}
        
        mailSender.send(message);
    }
}
