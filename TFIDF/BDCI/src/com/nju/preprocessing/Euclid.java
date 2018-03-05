package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//从0开始进行编号
public class Euclid {
	public static void main(String[] args) throws IOException {
		String pathTrain = "D:\\研究生\\20.CCF比赛\\tfidf\\train_tfidf.txt";;
		String pathTest = "D:\\研究生\\20.CCF比赛\\tfidf\\test_tfidf.txt";
		String pathDistance = null;
		String pathLocate = "D:\\研究生\\20.CCF比赛\\locate\\locate.txt";;
		
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
			//算出与所有的距离
			ArrayList<Double> list = new ArrayList<Double>();
			BufferedReader buffTrain = new BufferedReader(new InputStreamReader(new FileInputStream(fileTrain)));
			
			//余弦距离
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
			
			//欧几里得距离
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
			
			//算出最近的值及位置
			double min = 10000;
			int minLocate = -1;
			for(int i = 0;i<list.size();i++){
				if(min<list.get(i)){
					min = list.get(i);
					minLocate = i;
				}
			}
			list = new ArrayList<Double>();
			//将最近的值输出,不需要换行符
			fileLocateOut.write((String.valueOf(minLocate) + " ").getBytes());
			buffTrain.close();
		}
		fileLocateOut.close();
		buffTest.close();
	}
}
