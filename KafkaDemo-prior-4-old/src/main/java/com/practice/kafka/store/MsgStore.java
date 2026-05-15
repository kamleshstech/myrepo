package com.practice.kafka.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MsgStore {

	private List<String> store = new ArrayList<>();
	
	public void add(String msg) {
		store.add(msg);
	}
	public String readAll(){
		return store.toString();
	}
}
