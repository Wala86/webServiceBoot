package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	private @ResponseBody Map<String, Object> webhook(@RequestBody Map<String, Object> obj) throws JSONException {

		Map<String, Object> json = new HashMap<String, Object>();

		String speech =  obj.get("result").toString();

		System.out.println("speech : " + speech);
		
		json.put("speech", " The cost of shipping to  is  1000 euros.");
		json.put("displayText", " The cost of shipping for " + speech + " to  is  1000 euros.");

		json.put("source", "apiai-onlinestore-shipping");
		System.out.println("************* ******************" + obj.get("result"));
		return json;

	}
}
