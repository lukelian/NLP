package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class LDAWordProcess {
	
	public static void main(String[] args) throws IOException {
		
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\lda\\model_02000_keywords_all.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\lda\\model_02000_keywords_1000.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		HashSet<String> keywords = new HashSet<String>();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		int count = 0;
		while((line = bufferedReader.readLine())!=null){
			if(line.contains("Topic")){
				System.out.println(count);
				count = 0;
				continue;
			} else{
				if(count<1000){
					String[] lineSplit = line.split(" ");
					String temp = lineSplit[0].trim();
					keywords.add(temp);
				}
				count++;
			}
		}
		
		Iterator iter = keywords.iterator();
		count = 0;
		while(iter.hasNext()){
			count++;
			fileOut.write((iter.next() + " ").getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		System.out.println(count);
		
		bufferedReader.close();
		fileOut.close();
		
	}
	
}
