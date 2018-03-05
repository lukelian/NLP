package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class TestLabel {
	public static void main(String[] args) throws IOException {
		String pathRead = "D:\\研究生\\28.类案推荐论文\\dataset\\union_cases.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\result\\label_test_svm.txt";
		
		File fileUnionCases = new File(pathRead);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileUnionCases), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		int count = 0;
		while((line = buff.readLine())!=null){
			if(count>=40000 && count<=47999){
				String[] lineSplit = line.split(" ");
				fileOut.write((lineSplit[5]).getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			count++;
		}
		buff.close();
		fileOut.close();
	}
}
