package text_to_speech;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

@Component("service")
public class Text2SpeechServiceImpl 
	extends TextToSpeech
	implements Text2SpeechService {

	public Text2SpeechServiceImpl() {
		setUsernameAndPassword(
			"61dffcc2-3bbf-4f5a-b666-60e07a15ace9", "7fDFgUodXmem");
	}

	public List<Voice> getVoiceList() throws Exception {
		return getVoices().execute();
	}
}
