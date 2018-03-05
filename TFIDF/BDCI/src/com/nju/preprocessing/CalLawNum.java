package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CalLawNum {
	public static void main(String[] args) throws IOException, IOException {
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset_split\\train_law.txt";
		File file = new File(pathRead);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String line = null;
		int max = -10;
		while((line = bufferedReader.readLine())!=null){
			String[] lineSplit = line.split(",");
			for(int i = 0;i<lineSplit.length;i++){
				if(max<Integer.parseInt(lineSplit[i].trim())){
					max = Integer.parseInt(lineSplit[i].trim());
				}
			}
			
		}
		System.out.println(max);
		bufferedReader.close();
	}
}
