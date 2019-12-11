package com.awad.anthony.housecontroller.entititiesserilalizer;

import java.io.IOException;

import com.awad.anthony.housecontroller.entitities.DeviceType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DeviceTypeSerliazer extends StdSerializer<DeviceType>{
	
	 public DeviceTypeSerliazer() {
	        this(null);
	    }
	   
	    public DeviceTypeSerliazer(Class<DeviceType> t) {
	        super(t);
	    }

		@Override
		public void serialize(DeviceType value, JsonGenerator gen, SerializerProvider provider) 
				throws IOException {
			gen.writeStartObject();
			if(value.getId() > 0) {
				gen.writeNumberField("id", value.getId());
			}

			if(value.getName() != null ) {
				gen.writeStringField("name",value.getName());
			}
			
			if(value.getDeviceToken() != null ) {
				gen.writeStringField("device_token",value.getDeviceToken());
			}
			gen.writeEndObject();

			
		}
}
