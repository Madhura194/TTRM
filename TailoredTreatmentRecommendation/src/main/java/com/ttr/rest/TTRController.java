package com.ttr.rest;

import java.net.SocketException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttr.dto.GeolocationData;
import com.ttr.service.TTRService;

@RestController
@CrossOrigin(origins = "*" , maxAge = 3600)
public class TTRController {
	
	@Autowired
	TTRService ttrservice;

	
	@GetMapping("/nearby")
	public Object getautosuggest(@RequestParam("condition")String condition) {
		return ttrservice.getAutosuggestedTreatmentcentresbyCondition(condition.trim());
	}
	
	@GetMapping("/detect/drug")
	public List<String> getRecommendedDrugBasedOnDisease(@RequestParam("diseaseName")String diseaseName) {
		
		return ttrservice.detectDrugFromDisease(diseaseName);
	}
	
	@GetMapping("/get/geolocation")
	public GeolocationData geolocationOftheUser(HttpServletRequest request) throws SocketException {
		String ipaddress=ttrservice.getClientIp(request);
	    return ttrservice.getGeolocationFromIp(ipaddress);
	}
	
	

}
