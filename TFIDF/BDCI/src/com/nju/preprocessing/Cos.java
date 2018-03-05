package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cos {
	public static void main(String[] args) throws IOException {
		String pathTrain = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\train_40000_lda.txt";
		String pathTest = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\test_10000_lda.txt";
		String pathDistance = null;
		String pathLocate = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\merge\\locate.txt";
		
		File fileTrain = new File(pathTrain);
		File fileTest = new File(pathTest);
//		File fileDistance = new File(pathDistance);
		File fileLocate = new File(pathLocate);
		if(!fileLocate.exists()) fileLocate.createNewFile();
		
		FileOutputStream fileLocateOut = new FileOutputStream(fileLocate);
		
		BufferedReader buffTest = new BufferedReader(new InputStreamReader(new FileInputStream(fileTest)));
		BufferedReader buffTrain = new BufferedReader(new InputStreamReader(new FileInputStream(fileTrain)));
		String lineTest = null;
		String lineTrain = null;
		
		ArrayList<ArrayList<Double>> testAll = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> trainAll = new ArrayList<ArrayList<Double>>();
		
		while((lineTest = buffTest.readLine())!=null){
			String[] lineSplit = lineTest.split(" ");
			ArrayList<Double> testAllTemp = new ArrayList<Double>();
			for(int i = 0;i<lineSplit.length;i++){
				testAllTemp.add(Double.valueOf(lineSplit[i]));
			}
			testAll.add(testAllTemp);
		}
		buffTest.close();
		
//		int count = 0;
		while((lineTrain = buffTrain.readLine())!=null){
			//这里要分清楚两个问题，序号和计数号，序号从0开始，计数号从1开始，序号控制找寻最佳的匹配，计数号控制读入的范围
//			count++;
			
			//30000--40000
//			if(count<=29999) continue;
			//15000--29999，应该在序号上加14999
//			if(count<=14999) continue;
//			if(count>29999) break;
			//1--14999,总共14999个
//			if(count>14999) break;
			String[] lineSplit = lineTrain.split(" ");
			ArrayList<Double> trainAllTemp = new ArrayList<Double>();
			for(int i = 0;i<lineSplit.length;i++){
				trainAllTemp.add(Double.valueOf(lineSplit[i]));
			}
			trainAll.add(trainAllTemp);
//			System.out.println(count);
		}
		buffTrain.close();
		
//		long beginTime = System.currentTimeMillis();
		for(int i = 0;i<testAll.size();i++){
//			String[] testValueString = testAll.get(i).split(" ");
			ArrayList<Double> list = new ArrayList<Double>();
			for(int j = 0;j<trainAll.size();j++){
//				String[] trainValueString = trainAll.get(j).split(" ");
				double fenzi = 0.0;
				double fenmu1 = 0.0;
				double fenmu2 = 0.0;
				for(int k = 0;k<trainAll.get(j).size();k++){
					double testValue = testAll.get(i).get(k);
					double trainValue = trainAll.get(j).get(k);
					if(testValue!=0||trainValue!=0){
						fenzi = fenzi + testValue * trainValue;
						fenmu1 = fenmu1 + testValue*testValue;
						fenmu2 = fenmu2 + trainValue*trainValue;
					}
				}
				if(fenmu1==0||fenmu2==0){
					list.add(10.0);
				}else{
					list.add(fenzi/(Math.sqrt(fenmu1)*Math.sqrt(fenmu2)));
				}
				
			}
			//算出最近的值及位置
			double max = -10000;
			int maxLocate = -1;
			for(int j = 0;j<list.size();j++){
				if(max<list.get(j)){
					max = list.get(j);
					//30000--40000个, 29999--39999
//					maxLocate = j+29999;
					//15000--29999个, 14999--29998
//					maxLocate = j+14999;
					//1--14999个, 0--14998
					maxLocate = j;
				}
			}
			list = new ArrayList<Double>();
			//将最近的值输出,不需要换行符
//			long endTime = System.currentTimeMillis() - beginTime;
//			long wasteTime=endTime-beginTime;
//			double seconds=wasteTime/1000;
//			System.out.println("耗时：" + seconds+ "秒");
//			System.out.println(String.valueOf(maxLocate));
			fileLocateOut.write((String.valueOf(maxLocate) + " " + max + " ").getBytes());
			fileLocateOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		fileLocateOut.close();
	}
}
