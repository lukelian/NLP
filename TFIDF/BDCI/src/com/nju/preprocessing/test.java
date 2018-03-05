package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class test {
	public static void main(String[] args) throws IOException {
		String pathRead = "D:\\研究生\\20.CCF比赛\\tfidf\\tfidf.txt";
		File fileRead = new File(pathRead);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead)));
		LineNumberReader lnr = new LineNumberReader(new FileReader(fileRead));
		lnr.skip(Long.MAX_VALUE);
		System.out.println(lnr.getLineNumber() + 1);
		int count = 0;
		String line = null;

//		while((line = buff.readLine())!=null){
//			count++;
//		}
//		System.out.println(String.valueOf(count));
	}
}
