package com.awad.anthony.housecontroller.entitities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

import com.awad.anthony.housecontroller.entititiesserilalizer.DeviceTypeSerliazer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="device_type")
@JsonSerialize(using = DeviceTypeSerliazer.class)
public class DeviceType {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	String name;

	@Column(name="device_token")
	private String deviceToken;
	public DeviceType() {}

	public static DeviceType fromJSON(JSONObject object) throws UnsupportedOperationException, JSONException{
		DeviceType deviceType = new DeviceType();
		if(object.has("device_name") && object.getString("device_name") != null)
			deviceType.setName(object.getString("device_name"));
		else
			throw new UnsupportedOperationException("device_name unavailable or format exception");
		
		if(object.has("device_token") && object.getString("device_token") != null)
			deviceType.setDeviceToken(object.getString("device_token"));
		else
			throw new UnsupportedOperationException("device_token unavailable or format exception");
		
		return deviceType;
	}
	
	public DeviceType(int id, String name, String deviceToken) {
		super();
		this.id = id;
		this.name = name;
		this.deviceToken = deviceToken;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

}
