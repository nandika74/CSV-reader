/**
 * 
 */
package com.imdb.data.csv.pojo.parser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author A1855
 *
 */
public class StringListDeserializer extends JsonDeserializer<List<String>> {

	@Override
	public List<String> deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		return Arrays.asList(parser.getText());
	}
}
