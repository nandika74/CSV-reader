/**
 * 
 */
package com.imdb.data.csv.pojo.parser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author A1855
 *
 */
public class NumericBooleanDeserializer extends JsonDeserializer<Boolean> {

	@Override
	public Boolean deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		return !"0".equals(parser.getText());
	}
}
