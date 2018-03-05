import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class Final {
	public static void main(String[] args) throws IOException {
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\result_for_test\\multi_label\\similar_lda_result_merge.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\result_for_test\\multi_label\\similar_1W.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split(" ");
			fileOut.write(lineSplit[2].getBytes("UTF-8"));
			fileOut.write(System.getProperty("line.separator").getBytes("UTF-8"));
		}
		buff.close();
		fileOut.close();
	}
}
