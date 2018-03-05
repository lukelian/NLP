package com.nju.preprocessing;

import java.io.IOException;

public class RunMergeData {
	public static void main(String[] args) throws IOException {
		
		String pathRead_train = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset\\train.txt";
		String pathRead_test = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset\\test.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\detail_all.txt";
		String pathPenalize = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\train_penalize.txt";
		String pathTrainSerial = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\train_serial.txt";
		String pathLaw = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\train_law.txt";
		String pathTestSerial = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\test_serial.txt";
		
//		String pathRead_train = "D:\\�о���\\20.CCF����\\1-train\\train.txt";
//		String pathRead_test = "D:\\�о���\\20.CCF����\\2-test\\test.txt";
//		String pathCopy = "D:\\�о���\\20.CCF����\\detail\\detail_all.txt";
//		String pathPenalize = "D:\\�о���\\20.CCF����\\detail\\train_penalize.txt";
//		String pathTrainSerial = "D:\\�о���\\20.CCF����\\detail\\train_serial.txt";
//		String pathLaw = "D:\\�о���\\20.CCF����\\detail\\train_law.txt";
//		String pathTestSerial = "D:\\�о���\\20.CCF����\\detail\\test_serial.txt";
		
		MergeData mergeData = new MergeData(pathRead_train, pathRead_test, pathCopy, pathPenalize, pathLaw, pathTrainSerial, pathTestSerial);
		mergeData.Merge();
	}
}
