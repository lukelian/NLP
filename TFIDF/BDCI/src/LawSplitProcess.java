import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class LawSplitProcess {
	public static void main(String[] args) throws IOException {
		
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\law\\law.txt";
		String pathDetail = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\law\\law_detail.txt";
		
		File fileRead = new File(pathRead);
		File fileDetail = new File(pathDetail);
		if(!fileDetail.exists()) fileDetail.createNewFile();
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileDetail);
		
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split("\t");
			fileOut.write(lineSplit[1].getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		fileOut.close();
		buff.close();
	}
}
