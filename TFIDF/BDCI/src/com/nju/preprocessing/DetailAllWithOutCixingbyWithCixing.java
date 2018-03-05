package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DetailAllWithOutCixingbyWithCixing {
	
	static String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\fenci_all.txt";
	static String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\fenci_all_without_cixing.txt";
	
//	static String pathRead = "D:\\研究生\\20.CCF比赛\\final\\detail_reduction\\detail_reduction_with_cixing.txt";
//	static String pathCopy = "D:\\研究生\\20.CCF比赛\\final\\detail_reduction\\detail_reduction_without_cixing.txt";
	
	public static void main(String[] args) throws IOException {
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				String[] temp = lineSplit[i].split("/");
				String word = temp[0];
				fileOut.write((word + " ").getBytes("UTF-8"));
			}
			fileOut.write(System.getProperty("line.separator").getBytes("UTF-8"));
		}
		buff.close();
		fileOut.close();
	}
}
