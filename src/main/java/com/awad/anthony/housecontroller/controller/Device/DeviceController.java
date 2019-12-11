package com.awad.anthony.housecontroller.controller.Device;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awad.anthony.housecontroller.entitities.Mobile;
import com.awad.anthony.housecontroller.service.MobileService;

@RestController
@RequestMapping(path = "/device")
public class DeviceController {

	@Autowired
	MobileService mobileService;

	@GetMapping(path = "/{id}", produces="application/json")
	public DeviceResult read(@PathVariable(value = "id") Integer id) {

		DeviceResult deviceResult = new DeviceResult();
		
		Mobile mobile = mobileService.findOne(id);
		if(mobile != null && mobile.getId() <= 0) {
			DeviceErrorResponse deviceErrorResponse = new DeviceErrorResponse("Mobile not found");
			deviceResult.setDeviceErrorResponse(deviceErrorResponse);
			return deviceResult;
		}
//		without change status
//		mobile.setConnected(true);
//		mobileService.changeStatus(mobile);
		
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(mobile);
		deviceResult.setMobiles(mobiles);
		
		//TODO handle error on empty and null
		return deviceResult;
	}
	
	@GetMapping(path = "/{id}/connect", produces="application/json")
	public DeviceResult connect(@PathVariable(value = "id") Integer id) {

		DeviceResult deviceResult = new DeviceResult();
		
		Mobile mobile = mobileService.findOne(id);
		if(mobile != null && mobile.getId() <= 0) {
			DeviceErrorResponse deviceErrorResponse = new DeviceErrorResponse("Mobile not found");
			deviceResult.setDeviceErrorResponse(deviceErrorResponse);
			return deviceResult;
		}
		
		mobile.setConnected(true);
		mobileService.save(mobile);
		
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(mobile);
		deviceResult.setMobiles(mobiles);
		
		//TODO USE JACKSON JSON
		return deviceResult;
	}
	
	@GetMapping(path = "/{id}/disconnect", produces="application/json")
	public DeviceResult disconnect(@PathVariable(value = "id") Integer id) {

		DeviceResult deviceResult = new DeviceResult();
		
		Mobile mobile = mobileService.findOne(id);
		if(mobile != null && mobile.getId() <= 0) {
			DeviceErrorResponse deviceErrorResponse = new DeviceErrorResponse("Mobile not found");
			deviceResult.setDeviceErrorResponse(deviceErrorResponse);
			return deviceResult;
		}
		
		mobile.setConnected(false);
		mobileService.save(mobile);
		
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(mobile);
		deviceResult.setMobiles(mobiles);
		
		//TODO USE JACKSON JSON
		return deviceResult;
	}
	
	@PostMapping(path = "/register", produces="application/json")
	public DeviceResult create(@RequestBody String body) {
		DeviceResult deviceResult = new DeviceResult();
		
		try {
			JSONObject object = new JSONObject(body);
			Mobile mobile = Mobile.fromJSON(object);
			mobile = mobileService.save(mobile);
			List<Mobile> mobiles = new ArrayList<Mobile>();
			if(mobile.getId() <=0)throw new UnsupportedOperationException("CREATE Error");
			mobiles.add(mobile);
			deviceResult.setMobiles(mobiles);
			return deviceResult ;
		}catch(JSONException e) {
			DeviceErrorResponse deviceErrorResponse = new DeviceErrorResponse(e.getMessage());
			deviceResult.setDeviceErrorResponse(deviceErrorResponse);
			e.printStackTrace();
			return deviceResult;
			
		}
		catch(UnsupportedOperationException e) {
			DeviceErrorResponse deviceErrorResponse = new DeviceErrorResponse(e.getMessage());
			deviceResult.setDeviceErrorResponse(deviceErrorResponse);
			e.printStackTrace();
			return deviceResult;
		}
		
	}


}
