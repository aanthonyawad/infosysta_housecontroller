package com.awad.anthony.housecontroller.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awad.anthony.housecontroller.entitities.Mobile;
import com.awad.anthony.housecontroller.service.MobileService;



@Controller
public class AdminMvcController {
	
	@Autowired
	MobileService mobileService;
	
	@GetMapping(path = "/", produces="application/json")
	public String mobileTabView(Model  model) {
		model.addAttribute("title", "Mobile Table");
		model.addAttribute("content", "bluh bluh bluh bluh");
		model.addAttribute("contentTitle", "Mobile table");
		List<Mobile> mobiles = mobileService.findAll();
		
		model.addAttribute("mobiles",mobiles);
		return "mobileTabView";
	}
	
	

}
