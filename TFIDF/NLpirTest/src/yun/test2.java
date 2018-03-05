package yun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class test2 {
	
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		String[] fileName = getFileName("D:\\time_without_hour");
		for(int i = 0;i<fileName.length;i++){
			String pathRead = "D:\\time_without_hour\\"+fileName[i];
			String pathCopy = "D:\\data3\\"+fileName[i];
			File fileRead = new File(pathRead);
			File fileCopy = new File(pathCopy);
			
			FileReader reader = new FileReader(fileRead);
			BufferedReader buffReader = new BufferedReader(reader);
			
			FileOutputStream fileCopyStream = new FileOutputStream(fileCopy);
			
			String line = null;
			while((line = buffReader.readLine())!=null){
				String[] lineTemp = line.split("-");
				fileCopyStream.write((lineTemp[0] + "-" + lineTemp[1]).getBytes("UTF-8"));
				fileCopyStream.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			buffReader.close();
			fileCopyStream.close();
		}
	}
}
