package com.n1books.dev.controller;

import java.util.List;

public interface Text2SpeechDAO {

	void insertText2Speech(Text2SpeechVO vo) throws Exception;

	List<Text2SpeechVO> getText2SpeechList() throws Exception; 

}
