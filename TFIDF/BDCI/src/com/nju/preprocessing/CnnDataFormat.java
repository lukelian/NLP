package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CnnDataFormat {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String pathAll = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_10000.txt";
		String pathLabel = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_penalize_10000.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_penalize_cnn.txt";
		
		File fileAll = new File(pathAll);
		File fileLabel = new File(pathLabel);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		BufferedReader buffAll = new BufferedReader(new InputStreamReader(new FileInputStream(fileAll), "UTF-8"));
		BufferedReader buffLabel = new BufferedReader(new InputStreamReader(new FileInputStream(fileLabel), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String lineAll = null;
		String lineLabel = null;
		lineLabel = buffLabel.readLine();
		String[] lineLabelSplit = lineLabel.split(" ");
		int count = 0;
		while((lineAll = buffAll.readLine())!=null){
			fileOut.write((lineLabelSplit[count].trim() + " " + lineAll.trim()).getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			count++;
		}
		buffAll.close();
		buffLabel.close();
		fileOut.close();
	}

}
