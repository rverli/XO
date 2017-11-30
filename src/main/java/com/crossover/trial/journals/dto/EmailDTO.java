package com.crossover.trial.journals.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable{

	 	
	private static final long serialVersionUID = 1L;
	
		private String to;
	    private String body;
	    private String subject;

	    public EmailDTO() {
	    }

	    public EmailDTO(String to, String subject, String body) {
	        this.to = to;
	        this.body = body;
	        this.subject = subject;
	    }

	    public String getTo() {
	        return to;
	    }

	    public void setTo(String to) {
	        this.to = to;
	    }

	    public String getBody() {
	        return body;
	    }

	    public void setBody(String body) {
	        this.body = body;
	    }

	    @Override
	    public String toString() {
	        return String.format("Email{to=%s, body=%s}", getTo(), getBody());
	    }

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}
}
