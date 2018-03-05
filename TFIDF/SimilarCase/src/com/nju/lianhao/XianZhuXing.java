package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;

public class XianZhuXing {
	public static void main(String[] args) throws IOException {
		
		String pathRead = "D:\\研究生\\28.类案推荐论文\\guize\\location_by_cixing.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\guize\\location_by_cixing_province.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		HashSet<String> set = new HashSet<String>();
		
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split(" ");
			String serial = null;
			String location = null;
			for(int i = 0;i<lineSplit.length;i++){
				if(i == 0){
					serial = lineSplit[0];
				}else{
					if(lineSplit[i].contains("省")){
						location = lineSplit[i].trim();
						set.add(location);
						break;
					}
				}
			}
			
			if(serial!=null && location!=null){
				fileOut.write((serial + " " + location).getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
		
		}
		buff.close();
		fileOut.close();
		System.out.println(set.size());
	}
}
