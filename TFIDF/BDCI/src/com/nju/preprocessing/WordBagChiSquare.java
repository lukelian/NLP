package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBagChiSquare {
	public static boolean isChinese(String str) {
		String regEx = "^[\u4e00-\u9fa5]{0,}$";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find())
			flg = true;

		return flg;
	}
	
	public static void main(String[] args) throws IOException {
		String pathRead = "D:\\研究生\\20.CCF比赛\\final\\wordbag_origion\\8000_40000.txt";
		String pathCopy = "D:\\研究生\\20.CCF比赛\\final\\wordbag_without_character\\8000_40000.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split("/");
			if(isChinese(lineSplit[0])){
				fileOut.write(lineSplit[0].getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
		}
		buff.close();
		fileOut.close();
	}
	
}
