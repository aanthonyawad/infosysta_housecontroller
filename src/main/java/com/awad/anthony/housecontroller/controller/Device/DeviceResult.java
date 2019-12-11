package com.awad.anthony.housecontroller.controller.Device;

import java.util.List;

import com.awad.anthony.housecontroller.entitities.Mobile;

public class DeviceResult {
	private DeviceErrorResponse deviceErrorResponse;
	private List<Mobile> mobiles;
	public DeviceErrorResponse getDeviceErrorResponse() {
		return deviceErrorResponse;
	}
	public void setDeviceErrorResponse(DeviceErrorResponse deviceErrorResponse) {
		this.deviceErrorResponse = deviceErrorResponse;
	}
	public List<Mobile> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<Mobile> mobiles) {
		this.mobiles = mobiles;
	}
}
