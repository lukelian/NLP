import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class CNNWordbag {
	public static void main(String[] args) throws IOException {
		String pathRead = "D:\\Development\\PycharmProjects\\fasttext_model.vec";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\wordbag_all.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split(" ");
			fileOut.write(lineSplit[0].getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		fileOut.close();
		buff.close();
	}
}
