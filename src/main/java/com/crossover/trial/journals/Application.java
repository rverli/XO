package com.crossover.trial.journals;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

@ComponentScan({"com.crossover.trial.journals"})
@EnableAutoConfiguration
@EnableJms
public class Application {

	public static final String ROOT;

	static {
		ROOT = System.getProperty("upload-dir", System.getProperty("user.home") + "/Documents/upload");
	}

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("journals.queue");
	}
	 
	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplicationBuilder(Application.class).build();
		app.run(args);
	}

}