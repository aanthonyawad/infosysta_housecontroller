package com.awad.anthony.housecontroller.entititiesserilalizer;

import java.io.IOException;

import com.awad.anthony.housecontroller.entitities.Action;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ActionSerliazer extends StdSerializer<Action>{
	 public ActionSerliazer() {
	        this(null);
	    }
	   
	    public ActionSerliazer(Class<Action> t) {
	        super(t);
	    }

		@Override
		public void serialize(Action value, JsonGenerator gen, SerializerProvider provider) 
				throws IOException {
			gen.writeStartObject();
			if(value.getId() > 0) {
				gen.writeNumberField("id", value.getId());
			}
			if(value.getMobile() != null && value.getMobile().getId() >0) {
				gen.writeNumberField("mobile_id", value.getMobile().getId());
				gen.writeStringField("mobile_name",value.getMobile().getName());
			}
			if(value.getMobile() != null && value.getActivity().getId() >0) {
				gen.writeNumberField("activity_id", value.getActivity().getId());
				gen.writeStringField("activity_name",value.getActivity().getName());
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
