package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CnnDataFormat {
	public static void main(String[] args) throws IOException {
		String pathFenci = "D:\\研究生\\28.类案推荐论文\\fenci\\fenci_filter_by_wordbag.txt";
		String pathDetail = "D:\\研究生\\28.类案推荐论文\\dataset\\union_cases.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\cnn\\cnn_all.txt";
		String pathTrain = "D:\\研究生\\28.类案推荐论文\\cnn\\cnn_train.txt";
		String pathTest = "D:\\研究生\\28.类案推荐论文\\cnn\\cnn_test.txt";
		
		File fileFenci = new File(pathFenci);
		File fileDetail = new File(pathDetail);
		File fileCopy = new File(pathCopy);
		File fileTrain = new File(pathTrain);
		File fileTest = new File(pathTest);
		
		BufferedReader buffFenci = new BufferedReader(new InputStreamReader(new FileInputStream(fileFenci), "UTF-8"));
		BufferedReader buffDetail = new BufferedReader(new InputStreamReader(new FileInputStream(fileDetail), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		FileOutputStream fileOutTrain = new FileOutputStream(fileTrain);
		FileOutputStream fileOutTest = new FileOutputStream(fileTest);
		
		String lineFenci = null;
		String lineDetail = null;
		int count = 0;
		while(((lineFenci = buffFenci.readLine())!=null)&&((lineDetail = buffDetail.readLine())!=null)){
			String[] lineSplit = lineDetail.split(" ");
			if(count<40000){
				fileOutTrain.write((lineFenci + " " + "__label__" + lineSplit[5].trim()).getBytes("UTF-8"));
				fileOutTrain.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			if(count>=40000 && count<50000){
//				fileOutTest.write((lineFenci + " " + "__label__" + lineSplit[5].trim()).getBytes("UTF-8"));
				fileOutTest.write((lineSplit[0] + "\t" + lineFenci).getBytes("UTF-8"));
				fileOutTest.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			/*
			fileOut.write((lineFenci + " " + "__label__" + lineSplit[5].trim()).getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			*/
			count++;
		}
		System.out.println(count);
		buffFenci.close();
		buffDetail.close();
		fileOut.close();
		fileOutTest.close();
		fileOutTrain.close();
	}
}
