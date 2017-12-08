package com.cit.deserializers;

import java.io.IOException;
import java.util.List;

import com.cit.entities.api.Product;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * Class used to deserialize JSON array of Product so they can be translated to List of Product
 * as this process requires extra logic to the way JSON are handled by Jackson
 */
public class ProductDeserializer  extends JsonDeserializer<List<Product>>{

	@Override
	public List<Product> deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<Product> products = mapper.readValue(jsonParser, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
		return products;
	}

}
