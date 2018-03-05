package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * 
 * 将测试集和训练集合并，并将其法条和罚金列分离出来
 * 
 * */
public class MergeData {
	String pathRead_train = null;
	String pathRead_test = null;
	String pathCopy = null;
	String pathPenalize = null;
	String pathLaw = null;
	String pathTrainSerial = null;
	String pathTestSerial = null;
	
	public MergeData(String pathRead_train, String pathRead_test, String pathCopy, String pathPenalize, String pathLaw, String pathTrainSerial, String pathTestSerial) {
		this.pathRead_test = pathRead_test;
		this.pathRead_train = pathRead_train;
		this.pathCopy = pathCopy;
		this.pathTrainSerial = pathTrainSerial;
		this.pathPenalize = pathPenalize;
		this.pathLaw = pathLaw;
		this.pathTestSerial = pathTestSerial;
	}
	
	public void Merge() throws IOException{
		File fileRead_test = new File(pathRead_test);
		File fileRead_train = new File(pathRead_train);
		File fileCopy = new File(pathCopy);
		File filePenalize = new File(pathPenalize);
		File fileLaw = new File(pathLaw);
		File fileTrainSerial = new File(pathTrainSerial);
		File fileTestSerial = new File(pathTestSerial);
		if(!fileCopy.exists()){fileCopy.createNewFile();}
		
		BufferedReader bufferedReaderTrain = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead_train), "UTF-8"));
		BufferedReader bufferedReaderTest = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead_test), "UTF-8"));
		FileOutputStream fileDetailOut = new FileOutputStream(fileCopy);
		FileOutputStream filePenalizeOut = new FileOutputStream(filePenalize);
		FileOutputStream fileLawOut = new FileOutputStream(fileLaw);
		FileOutputStream fileTrainSerialOut = new FileOutputStream(fileTrainSerial);
		FileOutputStream fileTestSerialOut = new FileOutputStream(fileTestSerial);
		
		ArrayList<String> trainAll = new ArrayList<String>();
		ArrayList<String> trainPenalize = new ArrayList<String>();
		ArrayList<String> trainSerial = new ArrayList<String>();
		ArrayList<String> trainLaw = new ArrayList<String>();
		ArrayList<String> testAll = new ArrayList<String>();
		ArrayList<String> testSerial = new ArrayList<String>();
		
		String line = null;
		
		while((line = bufferedReaderTest.readLine())!=null){
//			line = line.replace(String.valueOf((char)160), " ");
			String[] lineSplit = line.split("\t");
			testSerial.add(lineSplit[0]);
			testAll.add(lineSplit[1]);
		}
		bufferedReaderTest.close();
		
		while((line = bufferedReaderTrain.readLine())!=null){
			line = line.replace(String.valueOf((char)12288), " ");
			String[] lineSplit = line.split("\t");
			trainSerial.add(lineSplit[0]);
			trainAll.add(lineSplit[1]);
			trainPenalize.add(lineSplit[2]);
			trainLaw.add(lineSplit[3]);
		}
		bufferedReaderTrain.close();
		
		System.out.println("TrainAllNum:" + String.valueOf(trainAll.size()));
		System.out.println("TrainSerialNum:" + String.valueOf(trainSerial.size()));
		System.out.println("TrainLawNum:" + String.valueOf(trainLaw.size()));
		System.out.println("TrainPenalizeNum:" + String.valueOf(trainPenalize.size()));
		
		System.out.println("TestAllNum" + String.valueOf(testAll.size()));
		System.out.println("TestSerialNum:" + String.valueOf(testSerial.size()));
		
		for(int i = 0;i<trainAll.size();i++){
			fileDetailOut.write(trainAll.get(i).getBytes("UTF-8"));
			fileDetailOut.write(System.getProperty("line.separator").getBytes());
			
			
			filePenalizeOut.write((String.valueOf(trainPenalize.get(i)) + " ").getBytes());
			fileTrainSerialOut.write((String.valueOf(trainSerial.get(i)) + " ").getBytes());
			fileLawOut.write((String.valueOf(trainLaw.get(i))).getBytes());
			fileLawOut.write(System.getProperty("line.separator").getBytes());
		}
		
		for(int i = 0;i<testAll.size();i++){
			fileDetailOut.write(testAll.get(i).getBytes("UTF-8"));
			fileDetailOut.write(System.getProperty("line.separator").getBytes());
			
			fileTestSerialOut.write((testSerial.get(i) + " ").getBytes());
		}
		fileDetailOut.close();
		fileTrainSerialOut.close();
		filePenalizeOut.close();
		fileLawOut.close();
		fileTestSerialOut.close();
	}
	
	
	
}
