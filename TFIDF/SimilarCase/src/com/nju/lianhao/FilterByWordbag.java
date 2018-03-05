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

public class FilterByWordbag {
	public static void main(String[] args) throws IOException {
		String pathWordbag = "D:\\研究生\\28.类案推荐论文\\wordbag\\wordbag_200.txt";
		String pathDetail = "D:\\研究生\\28.类案推荐论文\\fenci\\fenci.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\dataset\\union_cases_detail_filter_by_wordbag200.txt";
		
		File fileWordbag = new File(pathWordbag);
		File fileDetail = new File(pathDetail);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buffWordbag = new BufferedReader(new InputStreamReader(new FileInputStream(fileWordbag), "UTF-8"));
		BufferedReader buffDetail = new BufferedReader(new InputStreamReader(new FileInputStream(fileDetail), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		ArrayList<String> wordbag = new ArrayList<String>();
		String line = null;
		while((line = buffWordbag.readLine())!=null){
			wordbag.add(line.trim());
		}
		
		while((line = buffDetail.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				String[] wordSplit = lineSplit[i].split("/");
				String word = wordSplit[0].trim();
				if(wordbag.contains(word)){
					fileOut.write((word + " ").getBytes("UTF-8"));
				}
			}
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		buffWordbag.close();
		buffDetail.close();
		fileOut.close();
	}
}
