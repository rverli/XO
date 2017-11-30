package com.crossover.trial.journals.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.crossover.trial.journals.dto.EmailDTO;

@Component
public class SenderMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviar( EmailDTO emailDTO ) throws MessagingException {
    	
        //SimpleMailMessage email = new SimpleMailMessage();
        //email.setTo( emailDTO.getTo() );
        //email.setSubject(emailDTO.getSubject());
        //email.setText( emailDTO.getBody() );
        //mailSender.send(email);
        
    	//Autorizacao para enviar email no google
    	//https://productforums.google.com/forum/#!topic/gmail-pt/EmEowutQ9Js
    	
        MimeMessage message = mailSender.createMimeMessage();
        
        // Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setTo( emailDTO.getTo() );
        helper.setText( emailDTO.getBody() );
        helper.setSubject( emailDTO.getSubject() );
        
        ClassPathResource file = new ClassPathResource("cat.jpg");
        helper.addAttachment("cat.jpg", file);
        
        mailSender.send(message);
    }
}
