package com.ttr.service;

import java.net.SocketException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ttr.dto.GeolocationData;

public interface TTRService {
	
	public List<String> detectDrugFromDisease(String diseaseName);

	String getClientIp(HttpServletRequest request) throws SocketException;

	public GeolocationData getGeolocationFromIp(String ipaddress);
	
	public Object getNearbyPlaces(String q,String apiKey,String longLat);
	
	

	public Object getAutosuggestedTreatmentcentresbyCondition(String condition);

}
