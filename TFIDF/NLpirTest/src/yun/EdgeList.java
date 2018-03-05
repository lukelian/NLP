package yun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EdgeList {
	
	String pathRead = null;
	String pathCopy = null;
	
	EdgeList(String pathRead, String pathCopy){
		this.pathRead = pathRead;
		this.pathCopy = pathCopy;
	}
	
	public void CalEdgeList() throws IOException{
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead)));
		
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		while((line = bufferedReader.readLine())!=null){
			String[] lineSplit = line.split(",");
			fileOut.write((lineSplit[0] + "," + lineSplit[1]).getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		bufferedReader.close();
		fileOut.close();
		
	}
	
}
