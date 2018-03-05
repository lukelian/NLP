package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindMax {
	
	public static void main(String[] args) throws IOException {
		String path0_14998 = "D:\\研究生\\20.CCF比赛\\卡方检验\\locate\\locate_1--14999.txt";
		String path14999_29998 = "D:\\研究生\\20.CCF比赛\\卡方检验\\locate\\locate_15000--29999.txt";
		String path29999_39999 = "D:\\研究生\\20.CCF比赛\\卡方检验\\locate\\locate_30000--40000.txt";
		String pathMax = "D:\\研究生\\20.CCF比赛\\卡方检验\\locate\\locateMax.txt";;
		
		File file0_14998 = new File(path0_14998);
		File file14999_29998 = new File(path14999_29998);
		File file29999_39999 = new File(path29999_39999);
		File fileMax = new File(pathMax);
		if(!fileMax.exists()) fileMax.createNewFile();
		
		BufferedReader buff0_14998 = new BufferedReader(new InputStreamReader(new FileInputStream(file0_14998)));
		BufferedReader buff14999_29998 = new BufferedReader(new InputStreamReader(new FileInputStream(file14999_29998)));
		BufferedReader buff29999_39999 = new BufferedReader(new InputStreamReader(new FileInputStream(file29999_39999)));
		
		FileOutputStream maxOut = new FileOutputStream(fileMax);
		
		ArrayList<Double> arr0_14998 = new ArrayList<Double>();
		ArrayList<String> serial0_14998 = new ArrayList<String>();
		ArrayList<Double> arr14999_29998 = new ArrayList<Double>();
		ArrayList<String> serial14999_29998 = new ArrayList<String>();
		ArrayList<Double> arr29999_39999 = new ArrayList<Double>();
		ArrayList<String> serial29999_39999 = new ArrayList<String>();
		
		String line = null;
		while((line = buff0_14998.readLine())!=null){
			String[] lineSplit = line.split(" ");
			serial0_14998.add(lineSplit[0]);
			arr0_14998.add(Double.valueOf(lineSplit[1]));
		}
		buff0_14998.close();
		
		while((line = buff14999_29998.readLine())!=null){
			String[] lineSplit = line.split(" ");
			serial14999_29998.add(lineSplit[0]);
			arr14999_29998.add(Double.valueOf(lineSplit[1]));
		}
		buff14999_29998.close();
		
		while((line = buff29999_39999.readLine())!=null){
			String[] lineSplit = line.split(" ");
			serial29999_39999.add(lineSplit[0]);
			arr29999_39999.add(Double.valueOf(lineSplit[1]));
		}
		buff29999_39999.close();
		
		for(int i = 0;i<arr0_14998.size();i++){
			double max = -10000.0;
			String maxLocate = null;
			if(max<arr0_14998.get(i)){
				max = arr0_14998.get(i);
				maxLocate = serial0_14998.get(i);
			}
				
			if(max<arr14999_29998.get(i)){
				max = arr14999_29998.get(i);
				maxLocate = serial14999_29998.get(i);
			}
			
			if(max<arr29999_39999.get(i)){
				max = arr29999_39999.get(i);
				maxLocate = serial29999_39999.get(i);
			}
			
			maxOut.write((maxLocate + " " + max).getBytes());
			maxOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		maxOut.close();
		
		
		
	}
	
}
