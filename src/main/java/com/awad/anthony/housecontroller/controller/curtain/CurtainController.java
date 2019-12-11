package com.awad.anthony.housecontroller.controller.curtain;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awad.anthony.housecontroller.Application;
import com.awad.anthony.housecontroller.entitities.Action;
import com.awad.anthony.housecontroller.entitities.Activity;
import com.awad.anthony.housecontroller.entitities.Mobile;
import com.awad.anthony.housecontroller.helper.pubsub.Message;
import com.awad.anthony.housecontroller.helper.pubsub.publisher.CurtainPublisher;
import com.awad.anthony.housecontroller.helper.pubsub.publisher.Publisher;
import com.awad.anthony.housecontroller.service.ActionService;
import com.awad.anthony.housecontroller.service.ActivityService;
import com.awad.anthony.housecontroller.service.MobileService;

@RestController
@RequestMapping(path = "/curtain")
public class CurtainController {
	@Autowired
	MobileService mobileService;
	
	@Autowired
	private ActivityService activityService;
	

	@Autowired
	private ActionService actionService;
	
	
	@PostMapping(path = "/open", produces="application/json")
	public CurtainResult open(@RequestBody String body) {
		CurtainResult curtainResult = new CurtainResult();
		try {
			JSONObject object = new JSONObject(body);
			// if there no id a json exception will be thrown and catched
			// and the error will be returned
			
			int id = object.getInt("id");
			
			Mobile mobile = mobileService.findOneConnected(id);
			//check if mobile exists by id
			if(!(mobile != null && mobile.getId() > 0 )){
				//mobile doesn't  exist throw error
				throw new UnsupportedOperationException("Mobile not found.");
			}
			 //mobile found close curtain.
			
			//create the message
			Message message = new Message("open");
			
			//create the publisher
			
			Publisher publisher = new CurtainPublisher(message);
			
			//attach to mediator
			Application.curtainMediator.publish(publisher);
			
			//log action in database
			Action action = new Action();
			Activity activity  = activityService.findByName("open");
			action.setActivity(activity);
			action.setMobile(mobile);
			actionService.insert(action);
			
			//return result
			curtainResult.setResult("open action in queue");
			
		} catch (JSONException e) {
			CurtainErrorResponse curtainErrorResponse = new CurtainErrorResponse(e.getMessage());
			curtainResult.setCurtainErrorResponse(curtainErrorResponse);
			e.printStackTrace();
			return curtainResult;
			
		}catch(UnsupportedOperationException e) {
			CurtainErrorResponse curtainErrorResponse = new CurtainErrorResponse(e.getMessage());
			curtainResult.setCurtainErrorResponse(curtainErrorResponse);
			e.printStackTrace();
			return curtainResult;
			
		}
		
		return curtainResult;
		
	}
	
	
	@PostMapping(path = "/close", produces="application/json")
	public CurtainResult close(@RequestBody String body) {
		CurtainResult curtainResult = new CurtainResult();
		try {
			JSONObject object = new JSONObject(body);
			// if there no id a json exception will be thrown and catched
			// and the error will be returned
			
			int id = object.getInt("id");
			
			Mobile mobile = mobileService.findOneConnected(id);
			//check if mobile exists by id
			if(!(mobile != null && mobile.getId() > 0 )){
				//mobile doesn't  exist throw error
				throw new UnsupportedOperationException("Mobile not found.");
			}
			 //mobile found close curtain.
			
			//create the message
			Message message = new Message("close");
			
			//create the publisher
			
			Publisher publisher = new CurtainPublisher(message);
			
			//attach to mediator
			Application.curtainMediator.publish(publisher);
			
			//log action in database
			Action action = new Action();
			Activity activity  = activityService.findByName("close");
			action.setActivity(activity);
			action.setMobile(mobile);
			actionService.insert(action);
			
			//return result
			curtainResult.setResult("close action in queue");
			
		} catch (JSONException e) {
			CurtainErrorResponse curtainErrorResponse = new CurtainErrorResponse(e.getMessage());
			curtainResult.setCurtainErrorResponse(curtainErrorResponse);
			e.printStackTrace();
			return curtainResult;
			
		}catch(UnsupportedOperationException e) {
			CurtainErrorResponse curtainErrorResponse = new CurtainErrorResponse(e.getMessage());
			curtainResult.setCurtainErrorResponse(curtainErrorResponse);
			e.printStackTrace();
			return curtainResult;
			
		}
		
		return curtainResult;
		
	}

}
