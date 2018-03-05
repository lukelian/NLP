package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBag {
	private String pathAllCases = null;
	private String pathAllCasesCopy = null;
	
	private File fileAllCases = null;
	private File fileAllCasesCopy = null;
	private HashSet<String> list = null;
	
	FileInputStream streamFileAllCases = null;
	FileOutputStream outputFileAllCases = null;
	InputStreamReader inputReaderAllCases = null;
	BufferedReader allCases = null;
	
	public static boolean isChinese(String str) {
		String regEx = "^[\u4e00-\u9fa5]{0,}$";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find())
			flg = true;

		return flg;
	}
	
	public WordBag(String pathAllCases, String pathAllCasesCopy) throws IOException{
		this.pathAllCases = pathAllCases;
		this.pathAllCasesCopy = pathAllCasesCopy;
		
		fileAllCases = new File(pathAllCases);
		fileAllCasesCopy = new File(pathAllCasesCopy);
		if(!fileAllCasesCopy.exists()) fileAllCasesCopy.createNewFile();
		
		streamFileAllCases = new FileInputStream(fileAllCases);
		inputReaderAllCases = new InputStreamReader(streamFileAllCases,"UTF-8");
		allCases = new BufferedReader(inputReaderAllCases);
		outputFileAllCases = new FileOutputStream(fileAllCasesCopy);
		
	}
	
	public void List() throws IOException{
		String line = null;
		list = new HashSet<String>();
		while((line = allCases.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				String[] lineAll = lineSplit[i].split("/");
				if(lineAll.length>=2){
					if(lineAll[1].contains("n")&&!lineAll[1].contains("nr")&&isChinese(lineAll[0])&&!(lineAll[0].length()==1)){
						String word = lineAll[0].trim();
						list.add(word);
					}
				}
			}
		}
		
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()){
			outputFileAllCases.write(iter.next().getBytes("UTF-8"));
			outputFileAllCases.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		
	}

	
}
