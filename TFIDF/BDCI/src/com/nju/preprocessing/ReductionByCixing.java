package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReductionByCixing {
	/*
	 * 
	 * 根据词性过滤单词
	 * 
	 * */
	private String pathRead = "";
	private String pathCopy = "";
	
	public static boolean isChinese(String str) {
		String regEx = "^[\u4e00-\u9fa5]{0,}$";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find())
			flg = true;

		return flg;
	}
	
	public ReductionByCixing(String pathRead, String pathCopy) {
		this.pathRead = pathRead;
		this.pathCopy = pathCopy;
	}
	
	public void Cal() throws IOException{
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileout = new FileOutputStream(fileCopy);
		
		String matchStr = ".*(/n|/vn|/nt|/ns|/v)";
		String line = null;
		while((line = bufferedReader.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				String word = lineSplit[i];
				if(word.contains("/")){
					String chinese = word.substring(0, word.lastIndexOf("/"));
					if(word.matches(matchStr)&&chinese.length()>1){
						fileout.write((chinese + " ").getBytes("UTF-8"));
					}
				}
			}
			fileout.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		bufferedReader.close();
		fileout.close();
	}
	
}
