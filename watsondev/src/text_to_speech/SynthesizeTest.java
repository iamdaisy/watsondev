package text_to_speech;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class SynthesizeTest {
	public static void main(String[] args) {
		TextToSpeech service = new TextToSpeech("bf2c3d40-6fd8-4450-becf-11c5420443e5", "VjhzTPpjE5cO");

		try {
			String text = "ふたりは まるで すてねこみたい";
			InputStream stream = service.synthesize(text, Voice.JA_EMI, AudioFormat.WAV).execute();
			InputStream in = WaveUtils.reWriteWaveHeader(stream);
			OutputStream out = new FileOutputStream("jp_sound.wav");
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			out.close();
			in.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
