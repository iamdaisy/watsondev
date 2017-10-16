package com.n1books.dev.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Text2SpeechRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(Text2SpeechRestController.class);
	@Autowired
	private Text2SpeechService service;
	
	@RequestMapping("displayJSON")
	public List<Text2SpeechVO> display_voice() throws Exception {
		return service.getText2SpeechList();

	}

}
