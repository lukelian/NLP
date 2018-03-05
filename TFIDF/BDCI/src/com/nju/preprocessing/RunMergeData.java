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
		
//		String pathRead_train = "D:\\研究生\\20.CCF比赛\\1-train\\train.txt";
//		String pathRead_test = "D:\\研究生\\20.CCF比赛\\2-test\\test.txt";
//		String pathCopy = "D:\\研究生\\20.CCF比赛\\detail\\detail_all.txt";
//		String pathPenalize = "D:\\研究生\\20.CCF比赛\\detail\\train_penalize.txt";
//		String pathTrainSerial = "D:\\研究生\\20.CCF比赛\\detail\\train_serial.txt";
//		String pathLaw = "D:\\研究生\\20.CCF比赛\\detail\\train_law.txt";
//		String pathTestSerial = "D:\\研究生\\20.CCF比赛\\detail\\test_serial.txt";
		
		MergeData mergeData = new MergeData(pathRead_train, pathRead_test, pathCopy, pathPenalize, pathLaw, pathTrainSerial, pathTestSerial);
		mergeData.Merge();
	}
}
