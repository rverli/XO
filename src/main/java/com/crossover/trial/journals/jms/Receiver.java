package com.crossover.trial.journals.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.crossover.trial.journals.dto.EmailDTO;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(EmailDTO email) {
        System.out.println("Received <" + email + ">");
    }

}
