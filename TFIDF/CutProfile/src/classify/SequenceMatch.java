package classify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SequenceMatch {
	
	String pathStandard = null;
	String pathFile = null;
	String pathCopy = null;
	
	public SequenceMatch(String pathFile, String pathStandard, String pathCopy){
		this.pathStandard = pathStandard;
		this.pathCopy = pathCopy;
		this.pathFile = pathFile;
	}
	
	public SequenceMatch(){}
	
	public int[] WhetherContains(ArrayList<String> fileCompare, ArrayList<String> standardCompare){
		int[] elementLocation = new int[fileCompare.size()];
		Arrays.fill(elementLocation, 0);
		if(fileCompare.size()<standardCompare.size()){
			return null;
		}else{
			int record = -1;
			for(int i = 0;i<standardCompare.size();i++){
				for(int j = record+1;j<fileCompare.size();j++){
					if(standardCompare.get(i).equals(fileCompare.get(j))){
						record = j;
						elementLocation[j] = 1;
						break;
					}
				}
			}
			int count = 0;
			//如果找到匹配的长度与原串不相同，则说明不匹配
			for(int i = 0;i<elementLocation.length;i++){
				if(elementLocation[i] != 0){
					count++;
				}
			}
			if(count!=standardCompare.size()){
				return null;
			}
			//找到匹配元素在原串中的位置，并返回位置结果
			int[] result = new int[count];
			int count2 = 0;
			for(int i = 0;i<elementLocation.length;i++){
				if(elementLocation[i]!=0){
					result[count2] = i;
					count2++;
				}
			}
			return result;
		}
	}
	
	public HashMap<Integer, ArrayList<String>> Matching(ArrayList<String> fileCompare, HashMap<Integer, ArrayList<String>> standard){
		ArrayList<String> standardCompare = new ArrayList<String>();
		HashMap<Integer, int[]> location = new HashMap<Integer, int[]>();
		HashMap<Integer, ArrayList<String>> result = new HashMap<Integer, ArrayList<String>>();
		for(int j = 0;j<standard.size();j++){//standard中序号是连续的，所以能这么做
			standardCompare = standard.get(j);
			//如果存在匹配的序列，就把它存储下来,whether存储的是此条标准在原序列中的位置
			int[] whether = WhetherContains(fileCompare, standardCompare);
			if(whether!=null){//如果是空的话，则说明此条序列不匹配，非空则将其存储下来
				//j即为匹配的属性号
				location.put(j, whether);//注意此处的location的key不连续，其中保存了所有的匹配结果
			}
		}
		if(location.size()!=0){//如果存在匹配的序列
			//找到最长串的位置，并用它替换掉原串中的字符
			int maxLength = -1;
			int maxLengthKey = -1;
			Iterator iter = location.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<Integer, int[]> entry = (Entry<Integer, int[]>) iter.next();
				int[] value = entry.getValue();
				if(value.length>maxLength){
					maxLength = value.length;
					maxLengthKey = entry.getKey();
				}
			}
			//进行替换
			int[] template = location.get(maxLengthKey);
			ArrayList<String> fileCompareTemp = new ArrayList<String>();
			for(int j = 0;j<fileCompare.size();j++){
				int flag = 0;
				for(int k = 0;k<template.length;k++){
					if(template[k] == j) flag = 1;
				}
				if(flag != 1) fileCompareTemp.add(fileCompare.get(j));
			}
			fileCompare = fileCompareTemp;
			//删除在location中多余的匹配结果
			while(iter.hasNext()){
				Map.Entry<Integer, int[]> entry = (Entry<Integer, int[]>) iter.next();
				int key = entry.getKey();
				if(key!=maxLengthKey){
					location.remove(key);
				}
			}
			result.put(maxLengthKey, fileCompare);
			return result;
		}else{//如果不存在匹配的序列
			return null;
		}
	}
	
	public void File2features() throws IOException{
		File fileStandard = new File(pathStandard);
		File fileFile = new File(pathFile);
		File fileCopy = new File(pathCopy);
		
		if(!fileCopy.exists()) fileCopy.createNewFile();
		FileReader readerStandard = new FileReader(fileStandard);
		FileReader readerFile = new FileReader(fileFile);
		BufferedReader standardBufferedReader = new BufferedReader(readerStandard);
		BufferedReader fileBufferedReader = new BufferedReader(readerFile);
		FileOutputStream outPutFeatures = new FileOutputStream(fileCopy, true);
		String line = null;
		int keyCount = 0;
		HashMap<Integer, ArrayList<String>> standard = new HashMap<Integer, ArrayList<String>>();
		HashMap<Integer, ArrayList<String>> file = new HashMap<Integer, ArrayList<String>>();
		//读入标准
		while((line = standardBufferedReader.readLine()) != null){
			String[] lineSplitString = line.split(" ");
			ArrayList<String> lineSplit = new ArrayList<String>();
			for(int i = 0;i<lineSplitString.length;i++){
				lineSplit.add(lineSplitString[i]);
			}
			standard.put(keyCount, lineSplit);
			keyCount++;
		}
		standardBufferedReader.close();
		keyCount = 0;
		//读入文件
		while((line = fileBufferedReader.readLine()) != null){
			String[] lineSplitString = line.split(" ");
			ArrayList<String> lineSplit = new ArrayList<String>();
			for(int i = 0;i<lineSplitString.length;i++){
				lineSplit.add(lineSplitString[i]);
			}
			file.put(keyCount, lineSplit);
			keyCount++;
		}
		keyCount = 0;
		fileBufferedReader.close();
		
		ArrayList<String> standardCompare = new ArrayList<String>();
		ArrayList<String> fileCompare = new ArrayList<String>();
		ArrayList<Integer> keyValue = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<String>> loopSave = new HashMap<Integer, ArrayList<String>>();
		HashMap<Integer, ArrayList<Integer>> features = new HashMap<Integer, ArrayList<Integer>>();
		//通过循环将一条Activity完全转换为特征序列，并将所有activity的结果保存至features
		for(int i = 0;i<file.size();i++){
			fileCompare = file.get(i);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			features.put(i, temp);//此行没有匹配，也会被储存进去，相当于每一行均有一个特征记录,但temp的size为0
			while((loopSave = Matching(fileCompare, standard))!=null){
				Iterator iter = loopSave.entrySet().iterator();
				Map.Entry<Integer, ArrayList<String>> entry = (Entry<Integer, ArrayList<String>>) iter.next();
				fileCompare = entry.getValue();
				//这里将Matching方法得到的结果中的特征序列加入到对应的activity中
				features.get(i).add(entry.getKey() + 26);//注意要加26，是因为可能会存在单个不匹配的，是属性的1--25，因为它是从0开始，所以+26
			}
			//将此条activity的未匹配特征加入到feature中
			for(int j = 0;j<fileCompare.size();j++){
				features.get(i).add(Integer.parseInt(fileCompare.get(j)));
			}
		}
		
		System.out.println(features.size());
		System.out.println(file.size());
		
		for(int i = 0;i<features.size();i++){
			if(features.get(i).size()==0){
				for(int j = 0;j<file.get(i).size();j++){
					outPutFeatures.write((file.get(i).get(j) + " ").getBytes("UTF-8"));
				}
				outPutFeatures.write(System.getProperty("line.separator").getBytes("UTF-8"));
			}else{
				for(int j = 0;j<features.get(i).size();j++){
					outPutFeatures.write((features.get(i).get(j) + " ").getBytes("UTF-8"));
				}
				outPutFeatures.write(System.getProperty("line.separator").getBytes("UTF-8"));
			}
		}
		outPutFeatures.close();
		
//		for(int i = 0;i<file.size();i++){
//			int signal = 1;
//			fileCompare = file.get(i);
//			HashMap<Integer, int[]> location = new HashMap<Integer, int[]>();
//			while(signal!=0){
//				
//			}
//			for(int j = 0;j<standard.size();j++){//standard中序号是连续的，所以能这么做
//				standardCompare = standard.get(j);
//				//如果存在匹配的序列，就把它存储下来
//				int[] whether = WhetherContains(fileCompare, standardCompare);
//				if(whether!=null){//如果是空的话，则说明不存在匹配的序列，非空则将其存储下来
//					location.put(j, whether);//注意此处的location的key不连续
//				}
//			}
//			//如果存在匹配的序列，则将其加入result，并且找到最长串的位置
//			if(location.size()!=0){
//				keyValue.add(i);
//				result.put(i, location);
//				//找到最长串的位置，并用它替换掉原串中的字符
//				int maxLength = -1;
//				int maxLengthNumber = 0;
//				Iterator iter = location.entrySet().iterator();
//				while(iter.hasNext()){
//					Map.Entry<Integer, int[]> entry = (Entry<Integer, int[]>) iter.next();
//					int[] value = entry.getValue();
//					if(value.length>maxLength){
//						maxLength = value.length;
//						maxLengthNumber = entry.getKey();
//					}
//				}
//				//进行替换
//				int[] template = location.get(maxLengthNumber);
//				for(int j = 0;j<template.length;j++){
//					file.get(i).remove(template[j]);
//				}
				
//				//删除在location中多余的匹配结果
//				while(iter.hasNext()){
//					Map.Entry<Integer, int[]> entry = (Entry<Integer, int[]>) iter.next();
//					int key = entry.getKey();
//					if(key!=maxLengthKey){
//						location.remove(key);
//					}
//				}
//				
//			}
//		}
	}
}
