package com.ttr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

    private String key;

    private String discover;

    private String autosuggest;

    private String ip;
    
    private String geolocation;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDiscover() {
		return discover;
	}

	public void setDiscover(String discover) {
		this.discover = discover;
	}

	public String getAutosuggest() {
		return autosuggest;
	}

	public void setAutosuggest(String autosuggest) {
		this.autosuggest = autosuggest;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}
    
    
    
    
}

