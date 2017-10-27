package com.watson.chat.dev;

import java.util.Scanner;

import org.junit.Test;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public class ConversationTest {
	
	@Test
	public void testConversation() {
		Scanner sc = new Scanner(System.in);
		Conversation service = new Conversation(Conversation.VERSION_DATE_2017_05_26);
		service.setUsernameAndPassword("7689fcc4-b013-4b84-8ba6-857df80f0e03", "ZdMoEDTBfPN6");
		
		MessageResponse response = null;
		Context context = null;
		MessageOptions options = null;
		String msg = "";
		StringBuffer watsonSay = null;
		
		while(true) {
			options = new MessageOptions.Builder()
				    .workspaceId("3ef06732-3e8f-4864-9496-0dab21ae982b")
				    .input(new InputData.Builder(msg).build())
				    .context(context)  //기존정보에 대한 대화내용과 같은 흐름을 만듬
				    .build();		
			response = service.message(options).execute();
			System.out.print("Watson : ");
			
			watsonSay = new StringBuffer();
			for(String text : response.getOutput().getText()) {
				watsonSay.append(text);
				watsonSay.append("  ");
				
			}
			
			System.out.println(watsonSay);
			System.out.print("I : ");
			msg = sc.nextLine();
			context = response.getContext();
			
		}
	}
}
