package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Split4W3W {
	public static void main(String[] args) throws IOException {
		
		String pathAllRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\cnn\\cnn_format_train.txt";
		String path4WCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\train_40000_cnn.txt";
		String path3WCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_10000_cnn.txt";
		
//		String pathAllRead = "D:\\研究生\\20.CCF比赛\\lda\\0.2_0.01_1200_100\\model-final.txt";
//		String path4WCopy = "D:\\研究生\\20.CCF比赛\\lda\\0.2_0.01_1200_100\\model-final4W.txt";
//		String path3WCopy = "D:\\研究生\\20.CCF比赛\\lda\\0.2_0.01_1200_100\\model-final3W.txt";
		
		File fileAllRead = new File(pathAllRead);
		File file4WCopy = new File(path4WCopy);
		File file3WCopy = new File(path3WCopy);
		if(!file3WCopy.exists()) file3WCopy.createNewFile();
		if(!file4WCopy.exists()) file4WCopy.createNewFile();
		
		FileOutputStream file4WOut = new FileOutputStream(file4WCopy);
		FileOutputStream file3WOut = new FileOutputStream(file3WCopy);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileAllRead),"UTF-8"));
		String line = null;
		int countTemp = 0;
		int count = 0;
		int change = 0;
		if(change==0){
			while((line = buff.readLine())!=null){
				
				if(count<40000){
					file4WOut.write((line).getBytes("UTF-8"));
					file4WOut.write(System.getProperty("line.separator").getBytes("UTF-8"));
				}else if(count>=40000&&count<50000){
					file3WOut.write(line.getBytes("UTF-8"));
					file3WOut.write(System.getProperty("line.separator").getBytes("UTF-8"));
				}else{
					
				}
				count = count + 1;
				countTemp++;
			}
		}else{
			line = buff.readLine();
			String[] lineSplit = line.split(" ");
			int i = 0;
			for(i = 0;i<40000;i++){
				file4WOut.write((lineSplit[i] + " ").getBytes("UTF-8"));
			}
			for(;i<50000;i++){
				file3WOut.write((lineSplit[i] + " ").getBytes("UTF-8"));
			}
		}
		
		System.out.println(countTemp);
		buff.close();
		file3WOut.close();
		file4WOut.close();
	}
}
