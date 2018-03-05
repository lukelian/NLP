package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnyouShaixuan {
	public static void main(String[] args) throws IOException {
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset\\train.txt";
		String pathCrime = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\human_filter\\法律总目_案由_罪行\\crime_done.txt";
		String pathLocationProvince = "D:\\研究生\\28.类案推荐论文\\guize\\location_by_cixing_province.txt";
		String pathSerialCrime = "D:\\研究生\\28.类案推荐论文\\data_preprocessing\\serial_crime.txt";
		String path3D = "D:\\研究生\\28.类案推荐论文\\data_preprocessing\\location_crime_penalize_3D.txt";
		String path3DNum = "D:\\研究生\\28.类案推荐论文\\data_preprocessing\\location_crime_penalize_3D_num.txt";
		
		File fileRead = new File(pathRead);
		File fileCrime = new File(pathCrime);
		File fileLocationProvince = new File(pathLocationProvince);
		File fileSerialCrime = new File(pathSerialCrime);
		File file3D = new File(path3D);
		File file3DNum = new File(path3DNum);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		BufferedReader buffCrime = new BufferedReader(new InputStreamReader(new FileInputStream(fileCrime), "UTF-8"));
		BufferedReader buffLocationProvince = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocationProvince), "UTF-8"));
		FileOutputStream fileOutSerialCrime = new FileOutputStream(fileSerialCrime);
		FileOutputStream fileOut3D = new FileOutputStream(file3D);
		FileOutputStream fileOut3DNum = new FileOutputStream(file3DNum);
		
		//构建存在的罪行列表
		ArrayList<String> crime = new ArrayList<String>();
		String lineCrime = null;
		while((lineCrime = buffCrime.readLine())!=null){
			crime.add(lineCrime.trim());
		}
		//构建位置列表
		HashMap<String, String> mapLocation = new HashMap<String, String>();
		String lineLocationProvince = null;
		while((lineLocationProvince = buffLocationProvince.readLine())!=null){
			String[] lineSplit = lineLocationProvince.split(" ");
			mapLocation.put(lineSplit[0].trim(), lineSplit[1].trim());
		}
		//读入原始数据
		String line = null;
//		ArrayList<String> serial = new ArrayList<String>();
//		ArrayList<String> detail = new ArrayList<String>();
//		ArrayList<String> law = new ArrayList<String>();
//		ArrayList<String> all = new ArrayList<String>();
		HashMap<String, String> mapSerialDetail = new HashMap<String, String>();
		HashMap<String, String> mapSerialPenalize = new HashMap<String, String>();
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split("\t");
			if(lineSplit.length == 4){
//				serial.add(lineSplit[0].trim());
//				detail.add(lineSplit[1].trim());
//				law.add(lineSplit[3].trim());
//				all.add(line.trim());
				mapSerialDetail.put(lineSplit[0].trim(), lineSplit[1].trim());
				mapSerialPenalize.put(lineSplit[0].trim(), lineSplit[2].trim());
			}
		}
		//筛选罪行,并把有明确罪行的案件保存下来
		HashMap<String, String> mapSerialCrime = new HashMap<String, String>();
		for(Map.Entry<String, String> entry : mapSerialDetail.entrySet()){
			String key = entry.getKey();//serial
			String value = entry.getValue();//detail
			
			for(int i = 0;i<crime.size();i++){
				String crimeNow = crime.get(i).trim();
				if(value.contains(crimeNow)){
					mapSerialCrime.put(key, crimeNow);//serial--crime
					fileOutSerialCrime.write((key + " " + crimeNow).getBytes("UTF-8"));
					fileOutSerialCrime.write((System.getProperty("line.separator")).getBytes("UTF-8"));
				}
			}
		}
		//取crime，location，penalize序号的交集，构建三维表
		HashMap<String, HashMap<String, ArrayList<String>>> sanweibiao = new HashMap<String, HashMap<String, ArrayList<String>>>();
		for(Map.Entry<String, String> entry : mapLocation.entrySet()){
			String serialLocation = entry.getKey();
			String nameLocation = entry.getValue();
			if(mapSerialCrime.containsKey(serialLocation)){
				String nameCrime = mapSerialCrime.get(serialLocation);
				String namePenalize = mapSerialPenalize.get(serialLocation);
				
				if(sanweibiao.containsKey(nameLocation)){
					if(sanweibiao.get(nameLocation).containsKey(nameCrime)){
						sanweibiao.get(nameLocation).get(nameCrime).add(namePenalize);//如果已经存在，则要把罚金放入容器当中
					}else{
						ArrayList<String> arrTemp = new ArrayList<String>();
						arrTemp.add(namePenalize);
						sanweibiao.get(nameLocation).put(nameCrime, arrTemp);
					}
				}else{
					ArrayList<String> arrTemp = new ArrayList<String>();
					HashMap<String, ArrayList<String>> mapTemp = new HashMap<String, ArrayList<String>>();
					
					arrTemp.add(namePenalize);
					mapTemp.put(nameCrime, arrTemp);
					
					sanweibiao.put(nameLocation, mapTemp);
				}
				
			}
		}
		//统计每一个HashMap中，罚金类别的数量
		HashMap<String, HashMap<String, Double>> mapLocationCount = new HashMap<String, HashMap<String, Double>>();
		for(Map.Entry<String, HashMap<String, ArrayList<String>>> entry : sanweibiao.entrySet()){
			HashMap<String, ArrayList<String>> mapTemp = entry.getValue();//从三维表中取出来一个crime--penalize
			String key = entry.getKey();
			HashMap<String, Double> mapDoubleTemp = new HashMap<String, Double>();
			for(Map.Entry<String, ArrayList<String>> entry2 : mapTemp.entrySet()){//计算crime--penalize_ave
				ArrayList<String> arr = entry2.getValue();
				String crimeTemp = entry2.getKey();
				int[] count = new int[8];
				int sum = 0;
				for(int i : count) count[i] = 0;
				for(int i = 0;i<arr.size();i++){
					count[Integer.parseInt(arr.get(i))]++;
					sum = sum + Integer.parseInt(arr.get(i));
				}
				double ave = ((double)sum)/8;
				
				mapDoubleTemp.put(crimeTemp, ave);//放到临时表里面
				
			}
			mapLocationCount.put(key, mapDoubleTemp);//把临时表添加到hashmap中
		}
		//输出sanweibiao
		for(Map.Entry<String, HashMap<String, ArrayList<String>>> entry : sanweibiao.entrySet()){
			String locationOutput = entry.getKey();
			HashMap<String, ArrayList<String>> mapOutput = entry.getValue();
			int classLocation = 0;
			for(Map.Entry<String, ArrayList<String>> entry2 : mapOutput.entrySet()){
				int classCrime = 0;
				String crimeOutput = entry2.getKey();
				ArrayList<String> penalizeOutput = entry2.getValue();
				fileOut3DNum.write((String.valueOf(classLocation) + " " + String.valueOf(classCrime) + " ").getBytes("UTF-8"));
				fileOut3D.write((locationOutput + " " + crimeOutput + " ").getBytes("UTF-8"));
				for(int i = 0;i<penalizeOutput.size();i++){
					fileOut3D.write((penalizeOutput.get(i) + " ").getBytes("UTF-8"));
					fileOut3DNum.write((penalizeOutput.get(i) + " ").getBytes("UTF-8"));
				}
			}
			fileOut3D.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			fileOut3DNum.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		buff.close();
		buffCrime.close();
		buffLocationProvince.close();
		fileOut3D.close();
		fileOut3DNum.close();
		fileOutSerialCrime.close();
	}
}
