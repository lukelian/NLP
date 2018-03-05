package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DocumentReduction {
	/*
	 * 根据词袋筛选原文
	 * */
	String pathDocumentFenci = null;
	String pathWordBag = null;
	String pathDocumentReduction = null;
	
	public DocumentReduction(String pathWordBag, String pathDocumentFenci, String pathDocumentReduction){
		this.pathDocumentFenci = pathDocumentFenci;
		this.pathWordBag = pathWordBag;
		this.pathDocumentReduction = pathDocumentReduction;
	}
	
	public void Cal() throws IOException{
		File fileDocumentFenci = new File(pathDocumentFenci);
		File fileWordBag = new File(pathWordBag);
		File fileDocumentReduction = new File(pathDocumentReduction);
		if(!fileDocumentReduction.exists()) fileDocumentReduction.createNewFile();
		
		BufferedReader buffDocumentFenci = new BufferedReader(new InputStreamReader(new FileInputStream(fileDocumentFenci), "UTF-8"));
		BufferedReader buffWordBag = new BufferedReader(new InputStreamReader(new FileInputStream(fileWordBag), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileDocumentReduction);
		
		ArrayList<String> wordbag = new ArrayList<String>();
		String line = null;
		while((line = buffWordBag.readLine())!=null){
			wordbag.add(line.trim());
		}
		buffWordBag.close();
		
		while((line = buffDocumentFenci.readLine())!=null){
			String[] lineSplit = line.split(" ");
			int count = 0;
			for(int i = 0;i<lineSplit.length;i++){
				String temp = lineSplit[i];
				if(wordbag.contains(temp)){
					count++;
					fileOut.write((temp + " ").getBytes("UTF-8"));
				}
			}
			if(count == 0){
				fileOut.write("盗窃罪".getBytes("UTF-8"));
			}
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		buffDocumentFenci.close();
		fileOut.close();
	}
}
