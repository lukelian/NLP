import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class DocumentLabel {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String pathDocument = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\train_40000.txt";
		String pathLawOri = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\train_law_40000.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\train_format_textcnn.txt";
		
		File fileDocument = new File(pathDocument);
		File fileLawOri = new File(pathLawOri);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		BufferedReader buffDocument = new BufferedReader(new InputStreamReader(new FileInputStream(fileDocument), "UTF-8"));
		BufferedReader buffLawOri = new BufferedReader(new InputStreamReader(new FileInputStream(fileLawOri), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String lineDocument = null;
		String lineLawOri = null;
		while(((lineDocument = buffDocument.readLine())!=null)&&((lineLawOri = buffLawOri.readLine())!=null)){
			String[] lineLawOriSplit = lineLawOri.split(",");
			fileOut.write((lineDocument + " " + "__label__").getBytes("UTF-8"));
			for(int i = 0;i<lineLawOriSplit.length;i++){
				fileOut.write((String.valueOf(lineLawOriSplit[i]) + " ").getBytes("UTF-8"));
			}
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		fileOut.close();
		buffDocument.close();
		buffLawOri.close();
	}
}
