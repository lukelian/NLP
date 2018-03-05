package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//��0��ʼ���б��
public class Euclid {
	public static void main(String[] args) throws IOException {
		String pathTrain = "D:\\�о���\\20.CCF����\\tfidf\\train_tfidf.txt";;
		String pathTest = "D:\\�о���\\20.CCF����\\tfidf\\test_tfidf.txt";
		String pathDistance = null;
		String pathLocate = "D:\\�о���\\20.CCF����\\locate\\locate.txt";;
		
		File fileTrain = new File(pathTrain);
		File fileTest = new File(pathTest);
//		File fileDistance = new File(pathDistance);
		File fileLocate = new File(pathLocate);
		if(!fileLocate.exists()) fileLocate.createNewFile();
		
		FileOutputStream fileLocateOut = new FileOutputStream(fileLocate);
		
		BufferedReader buffTest = new BufferedReader(new InputStreamReader(new FileInputStream(fileTest)));
		String lineTest = null;
		
		
		
		while((lineTest = buffTest.readLine())!=null){
			String[] testValueString = lineTest.split(" ");
			String lineTrain = null;
			//��������еľ���
			ArrayList<Double> list = new ArrayList<Double>();
			BufferedReader buffTrain = new BufferedReader(new InputStreamReader(new FileInputStream(fileTrain)));
			
			//���Ҿ���
			while((lineTrain = buffTrain.readLine())!=null){
				String[] trainValueString = lineTrain.split(" ");
				double fenzi = 0.0;
				double fenmu1 = 1.0;
				double fenmu2 = 1.0;
				
				for(int i = 0;i<testValueString.length;i++){
					fenzi = fenzi + Double.valueOf(testValueString[i]) * Double.valueOf(trainValueString[i]);
					fenmu1 = fenmu1 + Double.valueOf(testValueString[i])*Double.valueOf(testValueString[i]);
					fenmu2 = fenmu2 + Double.valueOf(trainValueString[i])*Double.valueOf(trainValueString[i]);
//					distance = distance + Math.abs(Double.valueOf(testValueString[i]) - Double.valueOf(trainValueString[i]));
				}
				list.add(fenzi/(Math.sqrt(fenmu1)*Math.sqrt(fenmu2)));
			}
			
			//ŷ����þ���
			/*
			while((lineTrain = buffTrain.readLine())!=null){
				
				String[] trainValueString = lineTrain.split(" ");
				double distance = 0.0;
				for(int i = 0;i<testValueString.length;i++){
					distance = distance + Math.abs(Double.valueOf(testValueString[i]) - Double.valueOf(trainValueString[i]));
				}
				list.add(distance);
			}
			*/
			
			//��������ֵ��λ��
			double min = 10000;
			int minLocate = -1;
			for(int i = 0;i<list.size();i++){
				if(min<list.get(i)){
					min = list.get(i);
					minLocate = i;
				}
			}
			list = new ArrayList<Double>();
			//�������ֵ���,����Ҫ���з�
			fileLocateOut.write((String.valueOf(minLocate) + " ").getBytes());
			buffTrain.close();
		}
		fileLocateOut.close();
		buffTest.close();
	}
}
