package com.crossover.trial.journals.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class EmailDTO implements Serializable{

	 	
	private static final long serialVersionUID = 1L;
	
		private String to;
	    private String body;
	    private String subject;
	    
	    private List<Map<String, String>> attachments;
	    
	    public EmailDTO() {
	    }

	    public EmailDTO(String to, String subject, String body, List<Map<String, String>> attachments) {
	        this.to = to;
	        this.body = body;
	        this.subject = subject;
	        this.attachments = attachments;
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
	        return String.format("Email{to=%s, body=%s, subject=%s}", getTo(), getBody(), getSubject());
	    }

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public List<Map<String, String>> getAttachments() {
			return attachments;
		}

		public void setAttachments(List<Map<String, String>> attachments) {
			this.attachments = attachments;
		}
}
