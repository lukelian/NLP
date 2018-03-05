package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class WordReduction {
	public static void main(String[] args) throws IOException {
		
		String pathRead = "D:\\研究生\\20.CCF比赛\\final\\wordbag_without_character\\8000_40000.txt";
		String pathCopy = "D:\\研究生\\20.CCF比赛\\final\\wordbag_canuse\\8000_40000.txt";
		
//		String pathRead = "D:\\研究生\\20.CCF比赛\\final\\wordbag_without_character\\8000_40000.txt";
//		String pathCopy = "D:\\研究生\\20.CCF比赛\\final\\wordbag_canuse\\8000_40000.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		HashMap<String, String> wordbagReduction = new HashMap<String, String>();
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String line = null;
		while((line = buffRead.readLine())!=null){
			String lineTemp = line.trim();
			wordbagReduction.put(lineTemp, "0");
		}
		buffRead.close();
		Iterator iter = wordbagReduction.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Entry) iter.next();
			String key = (String)entry.getKey();
			fileOut.write(key.getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		fileOut.close();
	}
}
