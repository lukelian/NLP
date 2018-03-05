package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FillEmpty {
	/*
	 * 处理法律条文的空行问题
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		String pathLawMLKNN = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\lda\\law_fusai.txt";
		String pathLawCos = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\lda\\model_01000_result.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\lda\\law_fusai_without_empty.txt";
		
		File fileLawMLKNN = new File(pathLawMLKNN);
		File fileLawCos = new File(pathLawCos);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		BufferedReader buffMLKNN = new BufferedReader(new InputStreamReader(new FileInputStream(fileLawMLKNN)));
		BufferedReader buffLawCos = new BufferedReader(new InputStreamReader(new FileInputStream(fileLawCos)));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String lineMLKNN = null;
		String lineCos = null;
		int count = 0;
		for(int i = 0;i<120000;i++){
			lineMLKNN = buffMLKNN.readLine();
			lineCos = buffLawCos.readLine();
			if(lineMLKNN!=null){
				count++;
				fileOut.write(lineMLKNN.getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}else{
				count++;
				String[] lineSplit = lineCos.split(" ");
				String[] lineSplitLaw = lineSplit[2].split(",");
				for(int j = 0;j<lineSplitLaw.length;j++){
					fileOut.write((lineSplitLaw[j] + " ").getBytes("UTF-8"));
				}
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			
		}
		fileOut.close();
		buffMLKNN.close();
		buffLawCos.close();
	}
}
