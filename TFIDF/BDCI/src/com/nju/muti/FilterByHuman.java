package com.nju.muti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.xml.sax.InputSource;

public class FilterByHuman {
	public static void main(String[] args) throws IOException {
		String pathStopDic = null;
		String pathCrime = null;
		String pathOri = null;
		String pathWordbag = null;
		String pathCopy = null;
		
		File fileStopDic = new File(pathStopDic);
		File fileCrime = new File(pathCrime);
		File fileOri = new File(pathOri);
		File fileWordbag = new File(pathWordbag);
		File fileCopy = new File(pathCopy);
		
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		BufferedReader buffStopDic = new BufferedReader(new InputStreamReader(new FileInputStream(fileStopDic), "UTF-8"));
		BufferedReader buffCrime = new BufferedReader(new InputStreamReader(new FileInputStream(fileCrime), "UTF-8"));
		BufferedReader buffWordbag = new BufferedReader(new InputStreamReader(new FileInputStream(fileWordbag), "UTF-8"));
		BufferedReader buffOri = new BufferedReader(new InputStreamReader(new FileInputStream(fileOri), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		ArrayList<String> listStop = new ArrayList<String>();
		ArrayList<String> listCrime = new ArrayList<String>();
		ArrayList<String> listWordbag = new ArrayList<String>();
		String line = null;
		
		while((line = buffStopDic.readLine())!=null){
			listStop.add(line.trim());
		}
		buffStopDic.close();
		
		while((line = buffCrime.readLine())!=null){
			listCrime.add(line.trim());
		}
		buffCrime.close();
		
		while((line = buffWordbag.readLine())!=null){
			listWordbag.add(line.trim());
		}
		
		while((line = buffOri.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				if(!(listStop.contains(lineSplit[i]))&&(listCrime.contains(lineSplit[i])||listWordbag.contains(lineSplit[i]))){
					fileOut.write((lineSplit[i] + " ").getBytes("UTF-8"));
					fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
				}
			}
		}
		fileOut.close();
		
	}
}
