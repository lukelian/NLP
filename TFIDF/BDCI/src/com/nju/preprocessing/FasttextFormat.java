package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FasttextFormat {
	public static void main(String[] args) throws IOException {
		/*
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_10000.txt";
		String pathRead2 = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_penalize_10000.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_penalize_10000_fasttext.txt";
		*/
		
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_10000.txt";
		String pathRead2 = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_penalize_10000.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_penalize_10000_fasttext.txt";
		
		File fileRead = new File(pathRead);
		File fileRead2 = new File(pathRead2);
		File fileCopy = new File(pathCopy);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead2), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		String[] tag = bufferedReader2.readLine().split(" ");
		int count = 0;
		while((line = bufferedReader.readLine())!=null){
			line = line.replaceAll("\n", "");
			String temp = line + "__label__" + tag[count];
			fileOut.write((temp).getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			count++;
		}
		bufferedReader.close();
		bufferedReader2.close();
		fileOut.close();
	}
}
