package conversation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public class ConversationTest {
	public static void main(String[] args) throws JSONException {
		String url = "https://gateway.watsonplatform.net/conversation/api";
		String username = "";
		String password = "vrkVp5wNxPZE";
		String workspace_id = "8df28dd7-a731-44ed-abe4-6e30ff4789f5";
		
		Scanner sc = new Scanner(System.in);
		ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03);
		service.setUsernameAndPassword(username, password);
		Map<String, Object> context = new HashMap<String, Object>();
		MessageRequest request = null;
		MessageResponse response = null;
		String msg = "";
		for(;;) {
			request = new MessageRequest.Builder().inputText(msg).context(context).build();
			response = service.message(workspace_id, request).execute();
			context = response.getContext();
			System.out.println(response);
			
			for(String key:context.keySet()) {
				System.out.println(key + ":" + context.get(key));
			}

			List<String> watsonsays = response.getText();
			for(String say:watsonsays) {
				System.out.println("Watson : " + say);
			}
			JSONObject watsonsay = new JSONObject();
			watsonsay.put("list", watsonsays);
			System.out.println("watsonsay : " + watsonsay);
			System.out.print("I : "); msg = sc.nextLine();
			if (msg.equals("종료")) break;
		}
		/*
		InputData input = new InputData.Builder("Hi").build();
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
		*/
	}
}
