package com.ttr.service;

import java.util.List;

import com.ttr.dto.GeolocationData;

public interface TTRService {
	
	public List<String> detectDrugFromDisease(String diseaseName);

	

	public GeolocationData getGeolocationFromIp(String ipaddress);
	
	
	

	public Object getAutosuggestedTreatmentcentresbyCondition(String condition);

}
