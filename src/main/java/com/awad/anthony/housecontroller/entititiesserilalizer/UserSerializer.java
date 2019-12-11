package com.awad.anthony.housecontroller.entititiesserilalizer;

import java.io.IOException;

import com.awad.anthony.housecontroller.entitities.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class UserSerializer extends StdSerializer<User>{
	
	 public UserSerializer() {
	        this(null);
	    }
	   
	    public UserSerializer(Class<User> t) {
	        super(t);
	    }

		@Override
		public void serialize(User value, JsonGenerator gen, SerializerProvider provider) 
				throws IOException {
			gen.writeStartObject();
			if(value.getId() > 0) {
				gen.writeNumberField("id", value.getId());
			}

			if(value.getName() != null ) {
				gen.writeStringField("name",value.getName());
			}

			if(value.getEmail() != null ) {
				gen.writeStringField("email",value.getEmail());
			}

			if(value.getPassword() != null ) {
				gen.writeStringField("password",value.getPassword());
			}
			
			
			gen.writeEndObject();

			
		}
}