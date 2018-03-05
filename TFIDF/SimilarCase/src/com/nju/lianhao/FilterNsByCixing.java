package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FilterNsByCixing {
	/*
	 * ���е�ַ�����ɸѡ
	 * 
	 * */
	public static void main(String[] args) throws IOException {
		
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\detail_train.txt";//�����Եķִ��ļ�
		String pathSerial = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset_split\\train_serial.txt";//����ļ�
		String pathCopy = "D:\\�о���\\28.�స�Ƽ�����\\guize\\location_by_cixing.txt";//���λ��
		
		File fileRead = new File(pathRead);
		File fileSerial = new File(pathSerial);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		BufferedReader buffSerial = new BufferedReader(new InputStreamReader(new FileInputStream(fileSerial), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String line = null;
		String[] lineSerial = buffSerial.readLine().split(" ");
		System.out.println(lineSerial.length);
		int count = 0;
		while(((line = buff.readLine())!=null)){
			String[] lineSplit = line.split(" ");
			fileOut.write((lineSerial[count] + " ").getBytes("UTF-8"));
			count++;
			for(int i = 0;i<lineSplit.length;i++){
				if(lineSplit[i].contains("ns")){
					String[] locationWithOutCixing = lineSplit[i].split("/");
					String temp = locationWithOutCixing[0];
					fileOut.write((temp + " ").getBytes("UTF-8"));
				}
			}
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		System.out.println(count);
		buff.close();
		buffSerial.close();
		fileOut.close();
	}

}
