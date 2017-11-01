package com.docs.app.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser<T> {
	private static final Logger log = LoggerFactory.getLogger(JSONParser.class);
	
	public T parseString(final String json, final Class<T> valueType) {
		final ObjectMapper mapper = new ObjectMapper();
		
		try {
			final T object = mapper.readValue(json, valueType);
			return object;
		} catch (final JsonGenerationException e) {
			log.info("JSON Generation Exception in JSON Parser: "+ e.getMessage());
		} catch (final JsonProcessingException e) {
			log.info("JSON Processing Exception in JSON Parser: "+ e.getMessage());
		} catch (final IOException e) {
			log.info("I/O Exception in JSON Parser: "+ e.getMessage());
		}
		
		return null;
	}
}
