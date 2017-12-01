package com.crossover.trial.journals.util;

import java.io.IOException;

import org.json.JSONException;

import com.crossover.trial.journals.dto.EmailDTO;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	public static String emailDTOToJson( EmailDTO email ) throws IOException, JSONException {
		
		String jsonInString = null;
		
		try {
			//jsonInString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString( email );
			jsonInString = new ObjectMapper().writeValueAsString( email );
		} catch (JsonGenerationException e) {
			throw new JSONException(e);
		} catch (JsonMappingException e) {
			throw new JSONException(e);
		} catch (IOException e) {
			throw new IOException(e);
		}
		
		return jsonInString;
	}
	
	public static EmailDTO jsonToEmailDTO( String jsonInString ) throws IOException, JSONException {
		
		EmailDTO emailDTO = null;
		
		try {
			emailDTO = new ObjectMapper().readValue(jsonInString, EmailDTO.class);
		} catch (JsonGenerationException e) {
			throw new JSONException(e);
		} catch (JsonMappingException e) {
			throw new JSONException(e);
		} catch (IOException e) {
			throw new IOException(e);
		}
		
		return emailDTO;
	}
}
