package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.InputMap;

public class FileterByTime {
	public static void main(String[] args) throws IOException {
//		String s = "������ӵ���2015��12��30����Ժ������������ӵ�";
//		String s2 = "��2016��1��6����Ժ�����ߡ���Ժ������ɺ���ͥ��2016��1��20�ձ�Ժ�ö���ֹ����";
		
		/*��������
		Matcher matcher = pattern.matcher(s);
		Matcher matcher2 = pattern.matcher(s2);
		if(matcher.find()){
			System.out.println(matcher.group(0));
			
		}
		if(matcher2.find()){
			System.out.println(matcher2.group(0));
		}
		*/
		
		
		Pattern pattern = Pattern.compile("��(\\d+��\\d+��\\d+��).*((����|�о�|�ö�)?)");
		
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset\\train.txt";
		String pathCopy = "D:\\�о���\\28.�స�Ƽ�����\\guize\\date.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split("\t");
			String dateStr = null;
			if(lineSplit.length == 4){
				Matcher matcher = pattern.matcher(lineSplit[1].trim());
				if(matcher.find()){
					dateStr = matcher.group(1);
				}
			}
			if(dateStr!=null){
				fileOut.write((lineSplit[0] + " " + dateStr + " " + lineSplit[2] + " " + lineSplit[3]).getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			
			/*
			if(dateStr!=null){
				fileOutDate.write((lineSplit[0] + " " + dateStr).getBytes("UTF-8"));
				fileOutDate.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			*/
		}
		buff.close();
		fileOut.close();
	}
}
