package com.nju.preprocessing;

import java.io.IOException;

public class Run {
	
	private static String pathRead = null;
	private static String pathDetailCases = null;
	private static String pathSerial = null;
	private static String pathPenalize = null;
	private static String pathProvision = null;
	
	public static void main(String[] args) throws IOException {
		
		pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset\\train.txt";
		pathDetailCases = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\cnn\\train_detail_cases.txt";
		pathSerial = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\cnn\\train_serial.txt";
		pathPenalize = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\cnn\\train_penalize.txt";
		pathProvision = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\cnn\\train_provision.txt";
		
//		pathRead = "D:\\data\\train.txt";
//		pathDetailCases = "D:\\data\\detail_cases.txt";
//		pathSerial = "D:\\data\\serial.txt";
//		pathPenalize = "D:\\data\\penalize.txt";
//		pathProvision = "D:\\data\\provision.txt";
		
		
		CutBySpace cut = new CutBySpace(pathRead, pathSerial, pathDetailCases, pathPenalize, pathProvision);
		cut.Cut();
		cut.Output();
	}
}
