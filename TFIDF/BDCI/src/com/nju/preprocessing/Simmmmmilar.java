package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 
 * 用于根据相似度输出最终法条结果
 * 
 * */

public class Simmmmmilar {
	public static void main(String[] args) throws IOException {
		
		String pathLocateAll = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\locate.txt";
		String pathSerial = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_10000_serial.txt";
		String pathPenalize = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\train_penalize_40000.txt";
		String pathLaw = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\train_law_40000.txt";
		String pathResult = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\similar_lda_result.txt";
		
//		String pathLocateAll = "D:\\研究生\\20.CCF比赛\\lda\\0.2_0.01_1200_100\\similar_lda_locate.txt";
//		String pathSerial = "D:\\研究生\\20.CCF比赛\\卡方检验\\label\\test_serial.txt";
//		String pathPenalize = "D:\\研究生\\20.CCF比赛\\卡方检验\\label\\train_penalize.txt";
//		String pathLaw = "D:\\研究生\\20.CCF比赛\\卡方检验\\label\\train_law.txt";
//		String pathResult = "D:\\研究生\\20.CCF比赛\\lda\\0.2_0.01_1200_100\\similar_lda_result.txt";
		
		File fileLocateAll = new File(pathLocateAll);
		File fileSerial = new File(pathSerial);
		File filePenalize = new File(pathPenalize);
		File fileLaw = new File(pathLaw);
		File fileResult = new File(pathResult);
		
		BufferedReader buffLocateAll = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocateAll)));
		BufferedReader buffSerial = new BufferedReader(new InputStreamReader(new FileInputStream(fileSerial)));
		BufferedReader buffPenalize = new BufferedReader(new InputStreamReader(new FileInputStream(filePenalize)));
		BufferedReader buffLaw = new BufferedReader(new InputStreamReader(new FileInputStream(fileLaw)));
		
		FileOutputStream outputResult = new FileOutputStream(fileResult);
		
		ArrayList<String> locateAll = new ArrayList<String>();
		ArrayList<String> serial = new ArrayList<String>();
		ArrayList<String> penalize = new ArrayList<String>();
		ArrayList<String> law = new ArrayList<String>();
		
		String line = null;
		while((line = buffLocateAll.readLine())!=null){
			String[] lineSplit = line.split(" ");
			locateAll.add(lineSplit[0]);
		}
		buffLocateAll.close();
		
		while((line = buffSerial.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				serial.add(lineSplit[i]);
			}
		}
		buffSerial.close();
		
		while((line = buffPenalize.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				penalize.add(lineSplit[i]);
			}
		}
		buffPenalize.close();
		
		while((line = buffLaw.readLine())!=null){
			law.add(line);
		}
		buffLaw.close();
		
		System.out.println(locateAll.size());
		System.out.println(serial.size());
		System.out.println(penalize.size());
		System.out.println(law.size());
		
		for(int i = 0;i<locateAll.size();i++){
			int locateNum = Integer.parseInt(locateAll.get(i));
			String serialNum = serial.get(i);
			String penalizeNum = penalize.get(locateNum);
			String lawNum = law.get(locateNum);
			
			outputResult.write((serialNum + " " + penalizeNum + " " + lawNum).getBytes());
			outputResult.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		outputResult.close();
	}
}
