package com.pkrm.personPojo;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {

	public JsonToJavaPojo json(String jsonString) throws IOException {
		ObjectMapper mapperObj = new ObjectMapper();
		JsonToJavaPojo jsonStr = null;

		try {
			jsonStr = mapperObj.readValue(jsonString, JsonToJavaPojo.class);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		System.out.println(jsonStr);
		return jsonStr;
	}
}
