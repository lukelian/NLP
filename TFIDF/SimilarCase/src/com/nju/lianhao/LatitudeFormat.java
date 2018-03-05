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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LatitudeFormat {
	
	public static void main(String[] args) throws IOException {
		String pathRead = "D:\\研究生\\28.类案推荐论文\\guize\\location_by_cixing_province.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\guize\\location_province_lng_lat.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		Latitude latitude = new Latitude();
		ArrayList<String> serial = new ArrayList<String>();
		String line = null;
		while((line = buff.readLine())!=null){
			HashSet<String> set = new HashSet<String>();
			String[] lineSplit = line.split(" ");
			serial.add(lineSplit[0]);
			String order = lineSplit[0].trim();
			for(int i = 1;i<lineSplit.length && i<4;i++){//这里不具有普适性，第一列是案件id，从第二列到第三列的才是真的
				set.add(lineSplit[i].trim());
			}
			
			String location = "";
			for(String str : set){
				location = location + str;
			}
			Map<String, String> map = latitude.getGeocoderLatitude(location);
			String lng = null;
			String lat = null;
			try {
				lng = map.get("lng");
				lat = map.get("lat");
				fileOut.write((order + " " + lng + " " + lat).getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			} catch (Exception e) {
				System.out.println(order);
				continue;
			} finally {
				
			}
		}
		fileOut.close();
		buff.close();
	}
	
}
