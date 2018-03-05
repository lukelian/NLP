package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Wordbag {
	public static void main(String[] args) throws IOException {
		String pathWordAll = "D:\\研究生\\28.类案推荐论文\\data_preprocessing\\fenci_reduction_by_cixing_stopwords.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\data_preprocessing\\wordbag_filter0.txt";
		
		File fileWordAll = new File(pathWordAll);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileWordAll), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split(" ");
			String[] cixing = lineSplit[1].split("/");
			if(Integer.parseInt(lineSplit[0])>200 && (!cixing[1].equals("ns")) && (!cixing[1].equals("m")) && (!cixing[1].equals("t"))){
				fileOut.write(cixing[0].getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
		}
		buff.close();
		fileOut.close();
	}
}
