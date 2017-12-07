package com.cit.deserializers;

import java.io.IOException;
import java.util.List;
import com.cit.entities.api.Order;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderDeserializer extends JsonDeserializer<List<Order>>{

	@Override
	public List<Order> deserialize(JsonParser jsonParser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<Order> orders = mapper.readValue(jsonParser, mapper.getTypeFactory().constructCollectionType(List.class, Order.class));

		return orders;
	}

}
