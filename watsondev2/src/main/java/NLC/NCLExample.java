package NLC;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

public class NCLExample {
	public static void main(String[] args) {
		NaturalLanguageClassifier service = new NaturalLanguageClassifier();
		service.setUsernameAndPassword("--", "--");
		Classification classification = service.classify("ebd2f7x230-nlc-24165", "오늘 비내려요?").execute(); //분류기ID, 조건
		System.out.println(classification);

	}

}