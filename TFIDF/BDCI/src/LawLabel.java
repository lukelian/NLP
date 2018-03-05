import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;;


public class LawLabel {
	public static void main(String[] args) throws IOException {
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\law\\law_detail_fenci_reduction.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\law\\law_detail_fenci_reduction_label.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		int count = 1;
		while((line = buff.readLine())!=null){
			fileOut.write((line + " __label__" + String.valueOf(count)).getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			count++;
		}
		buff.close();
		fileOut.close();
	}
}
