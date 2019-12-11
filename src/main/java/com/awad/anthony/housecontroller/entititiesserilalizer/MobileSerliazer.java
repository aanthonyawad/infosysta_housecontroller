package com.awad.anthony.housecontroller.entititiesserilalizer;

import java.io.IOException;

import com.awad.anthony.housecontroller.entitities.Mobile;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MobileSerliazer extends StdSerializer<Mobile>{
	
	 public MobileSerliazer() {
	        this(null);
	    }
	   
	    public MobileSerliazer(Class<Mobile> t) {
	        super(t);
	    }

		@Override
		public void serialize(Mobile value, JsonGenerator gen, SerializerProvider provider) 
				throws IOException {
			gen.writeStartObject();
			if(value.getId() > 0) {
				gen.writeNumberField("id", value.getId());
			}

			if(value.getName() != null ) {
				gen.writeStringField("name",value.getName());
			}
			
			if(value.getIpAddress() != null ) {
				gen.writeStringField("ip_address",value.getIpAddress());
			}

			gen.writeBooleanField("connected",value.isConnected());
			
			if(value.getDeviceType() != null ) {
				gen.writeObjectField("device_type",value.getDeviceType());
			}
			if(value.getActions() != null) {
				gen.writeObjectField("actions", value.getActions());
			}
			if(value.getInsertDate() != null ) {
				gen.writeStringField("insert_date",value.getInsertDate().toString());
			}
			if(value.getUpdateDate() != null ) {
				gen.writeStringField("update_date",value.getUpdateDate().toString());
			}
			gen.writeEndObject();

			
		}
}
