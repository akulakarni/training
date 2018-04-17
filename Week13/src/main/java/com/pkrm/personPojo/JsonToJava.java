package com.pkrm.personPojo;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pkrm.jms.Listener;

public class JsonToJava {
	private static org.apache.log4j.Logger logger = Logger.getLogger(JsonToJava.class);
	private static org.apache.log4j.Logger toFile = Logger.getLogger("Logger");
	public JsonToJavaPojo json(String jsonString) throws IOException {
		ObjectMapper mapperObj = new ObjectMapper();
		JsonToJavaPojo jsonStr = null;

		try {
			jsonStr = mapperObj.readValue(jsonString, JsonToJavaPojo.class);
		} catch (JsonProcessingException e) {

			logger.error(e.getMessage());
			toFile.error(e.getMessage());
		}
		logger.info(jsonStr);
		return jsonStr;
	}

}
