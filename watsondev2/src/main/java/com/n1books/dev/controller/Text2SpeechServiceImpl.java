package com.n1books.dev.controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

@Component("service")
public class Text2SpeechServiceImpl 
	extends TextToSpeech
	implements Text2SpeechService {
	
	@Autowired
	@Qualifier("ibatis")
	private Text2SpeechDAO text2SpeechDAO;

	public Text2SpeechServiceImpl() {
		setUsernameAndPassword(
			"61dffcc2-3bbf-4f5a-b666-60e07a15ace9", "7fDFgUodXmem");
	}

	public List<Voice> getVoiceList() throws Exception {
		return getVoices().execute();
	}

	@Override
	public InputStream getSpeech(String statement, String voice) throws Exception {
		return synthesize(statement, new Voice(voice,null,null), AudioFormat.OGG).execute();
	}

	@Override
	public void insertText2Speech(Text2SpeechVO vo) throws Exception {
		try {
			text2SpeechDAO.insertText2Speech(vo);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	@Override
	public List<Text2SpeechVO> getText2SpeechList() throws Exception {
		return text2SpeechDAO.getText2SpeechList();
	}

	@Override
	public void deleteText2Speech(int no) throws Exception {
		if (text2SpeechDAO.deleteText2Speech(no) == 0) {
			throw new RuntimeException("없는 번호입니다");
		} 
	}
	
}
