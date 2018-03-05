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
			//����ҵ�ƥ��ĳ�����ԭ������ͬ����˵����ƥ��
			for(int i = 0;i<elementLocation.length;i++){
				if(elementLocation[i] != 0){
					count++;
				}
			}
			if(count!=standardCompare.size()){
				return null;
			}
			//�ҵ�ƥ��Ԫ����ԭ���е�λ�ã�������λ�ý��
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
		for(int j = 0;j<standard.size();j++){//standard������������ģ���������ô��
			standardCompare = standard.get(j);
			//�������ƥ������У��Ͱ����洢����,whether�洢���Ǵ�����׼��ԭ�����е�λ��
			int[] whether = WhetherContains(fileCompare, standardCompare);
			if(whether!=null){//����ǿյĻ�����˵���������в�ƥ�䣬�ǿ�����洢����
				//j��Ϊƥ������Ժ�
				location.put(j, whether);//ע��˴���location��key�����������б��������е�ƥ����
			}
		}
		if(location.size()!=0){//�������ƥ�������
			//�ҵ������λ�ã��������滻��ԭ���е��ַ�
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
			//�����滻
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
			//ɾ����location�ж����ƥ����
			while(iter.hasNext()){
				Map.Entry<Integer, int[]> entry = (Entry<Integer, int[]>) iter.next();
				int key = entry.getKey();
				if(key!=maxLengthKey){
					location.remove(key);
				}
			}
			result.put(maxLengthKey, fileCompare);
			return result;
		}else{//���������ƥ�������
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
		//�����׼
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
		//�����ļ�
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
		//ͨ��ѭ����һ��Activity��ȫת��Ϊ�������У���������activity�Ľ��������features
		for(int i = 0;i<file.size();i++){
			fileCompare = file.get(i);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			features.put(i, temp);//����û��ƥ�䣬Ҳ�ᱻ�����ȥ���൱��ÿһ�о���һ��������¼,��temp��sizeΪ0
			while((loopSave = Matching(fileCompare, standard))!=null){
				Iterator iter = loopSave.entrySet().iterator();
				Map.Entry<Integer, ArrayList<String>> entry = (Entry<Integer, ArrayList<String>>) iter.next();
				fileCompare = entry.getValue();
				//���ｫMatching�����õ��Ľ���е��������м��뵽��Ӧ��activity��
				features.get(i).add(entry.getKey() + 26);//ע��Ҫ��26������Ϊ���ܻ���ڵ�����ƥ��ģ������Ե�1--25����Ϊ���Ǵ�0��ʼ������+26
			}
			//������activity��δƥ���������뵽feature��
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
//			for(int j = 0;j<standard.size();j++){//standard������������ģ���������ô��
//				standardCompare = standard.get(j);
//				//�������ƥ������У��Ͱ����洢����
//				int[] whether = WhetherContains(fileCompare, standardCompare);
//				if(whether!=null){//����ǿյĻ�����˵��������ƥ������У��ǿ�����洢����
//					location.put(j, whether);//ע��˴���location��key������
//				}
//			}
//			//�������ƥ������У��������result�������ҵ������λ��
//			if(location.size()!=0){
//				keyValue.add(i);
//				result.put(i, location);
//				//�ҵ������λ�ã��������滻��ԭ���е��ַ�
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
//				//�����滻
//				int[] template = location.get(maxLengthNumber);
//				for(int j = 0;j<template.length;j++){
//					file.get(i).remove(template[j]);
//				}
				
//				//ɾ����location�ж����ƥ����
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
