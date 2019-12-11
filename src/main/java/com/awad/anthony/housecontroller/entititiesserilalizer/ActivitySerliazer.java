package com.awad.anthony.housecontroller.entititiesserilalizer;

import java.io.IOException;

import com.awad.anthony.housecontroller.entitities.Activity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ActivitySerliazer extends StdSerializer<Activity>{
	 public ActivitySerliazer() {
	        this(null);
	    }
	   
	    public ActivitySerliazer(Class<Activity> t) {
	        super(t);
	    }

		@Override
		public void serialize(Activity value, JsonGenerator gen, SerializerProvider provider) 
				throws IOException {
			gen.writeStartObject();
			if(value.getId() > 0) {
				gen.writeNumberField("id", value.getId());
			}

			if(value.getName() != null ) {
				gen.writeStringField("name",value.getName());
			}
			
			
			gen.writeEndObject();

			
		}
}
