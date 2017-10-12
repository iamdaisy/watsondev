package NLC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

public class NLCExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		
		System.out.println("분류하고 싶은 문자열을 입력하세요.\n종료하려면 '종료'라고 입력하세요");
		for(;;) {
			String in = sc.nextLine();
			if (in.equals("종료")) break;
			list.add(in);
		}
		
		for(String str:list) {
			NaturalLanguageClassifier service = new NaturalLanguageClassifier();
			service.setUsernameAndPassword("3d10ffb6-84d6-4654-84ad-f0b6e98b08b3", "jqQ27kQGuyUB");
			Classification classification = service.classify("ebd15ex229-nlc-24230",str).execute();
			System.out.println(classification);
		}
		sc.close();
	}
}
