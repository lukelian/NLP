package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LawPenalize {
	public static void main(String[] args) throws IOException {
		String pathLaw = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset_split\\train_law.txt";
		String pathPenalize = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset_split\\train_penalize.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\law_penalize\\law_penalize.txt";
		
		File fileLaw = new File(pathLaw);
		File filePenalize = new File(pathPenalize);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		BufferedReader buffLaw = new BufferedReader(new InputStreamReader(new FileInputStream(fileLaw), "UTF-8"));
		BufferedReader buffPenalize = new BufferedReader(new InputStreamReader(new FileInputStream(filePenalize), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		String[] linePenalize = buffPenalize.readLine().split(" ");
		String line = null;
		int count = 0;
		while((line = buffLaw.readLine())!=null){
			String[] lineSplit = line.split(",");
			for(int i = 0;i<lineSplit.length;i++){
				if(map.containsKey(lineSplit[i])){
					map.get(lineSplit[i].trim()).add(linePenalize[count].trim());
				}else{
					ArrayList<String> temp = new ArrayList<String>();
					temp.add(linePenalize[count].trim());
					map.put(lineSplit[i].trim(), temp);
					
				}
			}
			count++;
		}
		for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
			String key = entry.getKey();
			fileOut.write((key + " ").getBytes("UTF-8"));
			for(int i = 0;i<entry.getValue().size();i++){
				fileOut.write((entry.getValue().get(i) + " ").getBytes("UTF-8"));
			}
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		buffLaw.close();
		buffPenalize.close();
		fileOut.close();
	}
}
