package yun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerticalList {
	
	private String pathRead;
	private String pathCopy;
	
	VerticalList(String pathRead, String pathCopy){
		this.pathRead = pathRead;
		this.pathCopy = pathCopy;
	}
	
	public void Vertical() throws IOException{
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String line = null;
		int count = 0;
		while((line = bufferedReader.readLine())!=null){
			String tempLine = line;
			fileOut.write((String.valueOf(count) + "," + tempLine).getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			count = count + 1;
		}
		bufferedReader.close();
		fileOut.close();
	}
	
}
