package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CasesLawFilter {
	
	public static void main(String[] args) throws IOException {
		String pathRead = "D:\\�о���\\28.�స�Ƽ�����\\guize\\��������.txt";
		String pathCopy = "D:\\�о���\\28.�స�Ƽ�����\\guize\\law_filter.txt";
		String pathSerial = "D:\\�о���\\28.�స�Ƽ�����\\guize\\law_filter_serial.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		File fileSerial = new File(pathSerial);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		FileOutputStream fileOutSerial = new FileOutputStream(fileSerial);
		
		String line = null;
		while((line = buff.readLine())!=null){
			if(line.contains("����")){
				fileOut.write(line.getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
				String[] lineSplit = line.split("\t");
				fileOutSerial.write((lineSplit[0] + " ").getBytes("UTF-8"));
//				fileOutSerial.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
		}
		buff.close();
		fileOut.close();
		fileOutSerial.close();
	}
	
}
