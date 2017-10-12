package text_to_speech;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text2SpeechTest2 {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beaninit.xml", Text2SpeechTest2.class);
		Text2SpeechService service = (Text2SpeechService)context.getBean("service"); //new Text2SpeechServiceImpl();
		try {
			System.out.println(service.getVoiceList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
