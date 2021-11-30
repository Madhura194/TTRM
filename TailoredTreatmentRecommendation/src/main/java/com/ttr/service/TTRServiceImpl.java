package com.ttr.service;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ttr.config.ApiProperties;
import com.ttr.dataaccess.TTRRepo;
import com.ttr.dto.AutosuggestData;
import com.ttr.dto.DiseaseDrug;
import com.ttr.dto.GeolocationData;

@Service
public class TTRServiceImpl implements TTRService {
	
	@Autowired
	ApiProperties apiProp;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<String> detectDrugFromDisease(String diseaseName) {
		List<String> drugs=new ArrayList<>();
	   List<DiseaseDrug> data= TTRRepo.data;
	   String drugorDrugs=data.stream()
			      .filter(d->d.getDisease().equalsIgnoreCase(diseaseName))
			      .findFirst()
			      .get()
			      .getDrug();
	   if(drugorDrugs.contains("/")) {
	   String[] drugsarr=drugorDrugs.split("/");
	   drugs=Arrays.asList(drugsarr);
	   }
	   else {
		   drugs.add(drugorDrugs);
	   }
	   
	   return drugs;

	}
	
	
	
	
	@Override
	public String getClientIp(HttpServletRequest request) throws SocketException {
		return restTemplate.getForEntity(apiProp.getIp(), String.class).getBody();
	}
	
	public GeolocationData getGeolocationFromIp(String ipaddress){
	
		return restTemplate.getForObject(apiProp.getGeolocation()+ipaddress, GeolocationData.class);
		
	}


	@Override
	public Object getNearbyPlaces(String q, String apiKey, String longLat) {
		Object nearByResponse = restTemplate
				                .getForObject(apiProp.getDiscover()+longLat+
				                		      "&q="+q+"&apiKey="+apiKey,Object.class);
	    	
		return nearByResponse;
	}




	@Override
	public Object getAutosuggestedTreatmentcentresbyCondition(String condition) {
		
		String ipaddressOfClient=restTemplate.getForEntity(apiProp.getIp(), String.class)
				                             .getBody();
		
		System.out.println("1");
		GeolocationData geodata=restTemplate
				                 .getForObject(apiProp.getGeolocation()+ipaddressOfClient, GeolocationData.class);
		String latlong = geodata.getLat()+","+geodata.getLon();
		String radius = "2500";
		System.out.println("2");
		String query = TTRRepo.data.stream().filter(d->d.getDisease().equalsIgnoreCase(condition)).findFirst().get()
				.getSpeciality();
		
		System.out.println(query);
		String url=apiProp.getAutosuggest()+"q="+query+"&in=circle:"+latlong+";r="+radius+"&apiKey="+apiProp.getKey();
		AutosuggestData getAutosuggestObject=restTemplate.getForObject(url, AutosuggestData.class);
		if (getAutosuggestObject.getItems().isEmpty()) {
			query=condition+" treatment";
			url=apiProp.getAutosuggest()+"q="+query+"&in=circle:"+latlong+";r="+radius+"&apiKey="+apiProp.getKey();
			getAutosuggestObject=restTemplate.getForObject(url, AutosuggestData.class);
		}
		return getAutosuggestObject;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Enumeration<NetworkInterface> e= NetworkInterface.getNetworkInterfaces();
	 * while(e.hasMoreElements()) { NetworkInterface n = (NetworkInterface)
	 * e.nextElement(); Enumeration ee = n.getInetAddresses(); while
	 * (ee.hasMoreElements()) { InetAddress i = (InetAddress) ee.nextElement();
	 * System.out.println(i.getHostAddress()); } } String ipAddress =
	 * request.getHeader("X-Forwarded-For"); if(StringUtils.isEmpty(ipAddress) ||
	 * "unknown".equalsIgnoreCase(ipAddress)) { ipAddress =
	 * request.getHeader("Proxy-Client-IP"); }
	 * 
	 * if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
	 * ipAddress = request.getHeader("WL-Proxy-Client-IP"); }
	 * 
	 * if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
	 * ipAddress = request.getRemoteAddr(); if(LOCALHOST_IPV4.equals(ipAddress) ||
	 * LOCALHOST_IPV6.equals(ipAddress)) { try { InetAddress inetAddress =
	 * InetAddress.getLocalHost(); ipAddress = inetAddress.getHostAddress(); } catch
	 * (UnknownHostException er) { er.printStackTrace(); } } }
	 * 
	 * if(!StringUtils.isEmpty(ipAddress) && ipAddress.length() > 15 &&
	 * ipAddress.indexOf(",") > 0) { ipAddress = ipAddress.substring(0,
	 * ipAddress.indexOf(",")); }
	 * 
	 * return ipAddress;
	 */

}
