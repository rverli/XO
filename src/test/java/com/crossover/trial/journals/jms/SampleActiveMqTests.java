package com.crossover.trial.journals.jms;

import static org.assertj.core.api.Assertions.assertThat;

import javax.jms.JMSException;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.context.SpringBootTest;

import com.crossover.trial.journals.service.jms.ProducerJMSJournalsService;

@Ignore
//@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleActiveMqTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private ProducerJMSJournalsService producer;

	@Test
	public void sendSimpleMessage() throws InterruptedException, JMSException {
		this.producer.send("Test message");
		Thread.sleep(1000L);
		assertThat(this.outputCapture.toString().contains("Test message")).isTrue();
	}

}
