/**
 * 
 */
package com.imdb.data.csv.pojo.parser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author A1855
 *
 */
public class StringListSerializer extends JsonSerializer<List<String>> {

    @Override
    public void serialize(List<String> list, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
        generator.writeString(String.join(",", list));
    }   
}