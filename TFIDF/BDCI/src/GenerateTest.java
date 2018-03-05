import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class GenerateTest {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String pathData = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_10000.txt";
		String pathSerial = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset_split\\test_serial.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_format_cnn.txt";
		
		File fileData = new File(pathData);
		File fileSerial = new File(pathSerial);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		BufferedReader buffData = new BufferedReader(new InputStreamReader(new FileInputStream(fileData), "UTF-8"));
		BufferedReader buffSerial = new BufferedReader(new InputStreamReader(new FileInputStream(fileSerial), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String lineData = null;
		String lineSerial = buffSerial.readLine();
		String[] lineSerialSplit = lineSerial.split(" ");
		int count = 0;
		while((lineData = buffData.readLine())!=null){
			String lineTemp = lineSerialSplit[count] + "\t" + lineData;
			fileOut.write(lineTemp.getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			count++;
		}
		buffData.close();
		buffSerial.close();
		fileOut.close();
	}
}
