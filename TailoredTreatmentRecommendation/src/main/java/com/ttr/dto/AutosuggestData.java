package com.ttr.dto;

import java.util.List;

public class AutosuggestData { 
	List<Item> items;
	List<Object> queryItems;
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<Object> getQueryItems() {
		return queryItems;
	}
	public void setQueryItems(List<Object> queryItems) {
		this.queryItems = queryItems;
	}
	
	


}