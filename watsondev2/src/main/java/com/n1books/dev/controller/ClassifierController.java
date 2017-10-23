package com.n1books.dev.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

@RestController
public class ClassifierController {

	@RequestMapping("weather")
	public ModelAndView weather() {
		return new ModelAndView("weather");
	}

	@RequestMapping(value = "/classifier", method = RequestMethod.POST)
	// public String classify(@RequestParam("content") String content) {
	public String classify(@RequestBody String content) throws UnsupportedEncodingException {
		System.out.println("classifier start");
		System.out.println(content);
		String user = "--";
		String pwd = "--";
		String classify_id = "--";

		NaturalLanguageClassifier service = new NaturalLanguageClassifier();
		service.setUsernameAndPassword(user, pwd);

		Classification classification = service.classify(classify_id, content).execute();
		System.out.println(classification);

		System.out.println("classifier end");
		return classification.toString();
	}
}
