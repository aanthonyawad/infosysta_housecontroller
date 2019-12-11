package com.awad.anthony.housecontroller.entitities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.json.JSONException;
import org.json.JSONObject;

import com.awad.anthony.housecontroller.entititiesserilalizer.MobileSerliazer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="mobile")
@JsonSerialize(using = MobileSerliazer.class)
public class Mobile {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	

	@Column(name="connected")
	private boolean connected;

	@Column(name="ip_address")
	private String ipAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_type_id", referencedColumnName = "id")
	private DeviceType deviceType;

	
	@OneToMany(mappedBy = "mobile")
    List<Action> actions;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	public static Mobile fromJSON(JSONObject object) throws UnsupportedOperationException, JSONException {
		Mobile mobile = new Mobile();
		
		if(object.has("name") && object.getString("name") !=null)
			mobile.setName(object.getString("name"));
		else
			throw new UnsupportedOperationException("name unavailable or format exception");
		
		//default when creating a mobile is true
		mobile.setConnected(true);
		
		if(object.has("ip_address") && object.getString("ip_address") != null)
			mobile.setIpAddress(object.getString("ip_address"));
		else
			throw new UnsupportedOperationException("ip_adress unavailable or format exception");
		
		
		mobile.setDeviceType(DeviceType.fromJSON(object));
		
		return mobile;
		
	}
	public Mobile() {}
	public Mobile(int id, String name, boolean connected, String ipAddress, DeviceType deviceType, List<Action> actions,
			Date insertDate, Date updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.connected = connected;
		this.ipAddress = ipAddress;
		this.deviceType = deviceType;
		this.actions = actions;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
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

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	

}
