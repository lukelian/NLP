package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CasesFilterByLaw {
	public static void main(String[] args) throws IOException {
		String pathCases = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset\\train.txt";
		String pathLaw = "D:\\研究生\\28.类案推荐论文\\guize\\law_filter_serial.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\guize\\cases_filter_by_serial.txt";
		
		File fileCases = new File(pathCases);
		File fileLaw = new File(pathLaw);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buffCases = new BufferedReader(new InputStreamReader(new FileInputStream(fileCases), "UTF-8"));
		BufferedReader buffLaw = new BufferedReader(new InputStreamReader(new FileInputStream(fileLaw), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String line = null;
		String[] lineLaw = buffLaw.readLine().split(" ");
		ArrayList<String> arrLawAll = new ArrayList<String>();
		for(int i = 0;i<lineLaw.length;i++){
			arrLawAll.add(lineLaw[i].trim());
		}
		int count = 0;
		while((line = buffCases.readLine())!=null){
			String[] lineSplit = line.split("\t");
			if(lineSplit.length == 4){
				String[] law = lineSplit[3].split(",");
				ArrayList<String> arrLaw = new ArrayList<String>();
				for(int i = 0;i<law.length;i++){
					arrLaw.add(law[i].trim());
				}
				int flag = 0;
				for(int i = 0;i<arrLaw.size();i++){
					if(arrLawAll.contains(arrLaw.get(i))){
						flag = 1;
						break;
					}
				}
				if(flag == 1){
					count++;
					fileOut.write((lineSplit[0] + " " + lineSplit[1] + " " + lineSplit[2] + lineSplit[3]).getBytes("UTF-8"));
				}
			}
		}
		System.out.println(count);
		buffCases.close();
		buffLaw.close();
		fileOut.close();
	}
}
