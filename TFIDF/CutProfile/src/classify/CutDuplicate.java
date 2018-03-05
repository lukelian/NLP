package classify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CutDuplicate {
	
	private String pathPatternWithSupportAndDuplicate = null;
	private String pathPatternWithoutDuplicate = null;
	private String pathCorrespondSupport = null;
	
//	String pathRead = "E:\\matrix_3\\pattern_22.txt";
//	String pathCopy = "E:\\matrix_4\\matrix_4_22.txt";
//	String pathSupport = "E:\\matrix_4\\support_22.txt";
	
	public CutDuplicate(String pathPatternWithSupportAndDuplicate, String pathPatternWithoutDuplicate, String pathCorrespondSupport){
		this.pathPatternWithSupportAndDuplicate = pathPatternWithSupportAndDuplicate;
		this.pathPatternWithoutDuplicate = pathPatternWithoutDuplicate;
		this.pathCorrespondSupport = pathCorrespondSupport;
	}
	
	public void DeDumplication() throws UnsupportedEncodingException, IOException{
		String pathRead = pathPatternWithSupportAndDuplicate;
		String pathCopy = pathPatternWithoutDuplicate;
		String pathSupport = pathCorrespondSupport;
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		File supportOutput = new File(pathSupport);
		
		HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
		HashMap<Integer, String> support = new HashMap<Integer, String>();
		String line = null;
		
		if(!fileCopy.exists()) fileCopy.createNewFile();
		if(!fileRead.exists()) fileRead.createNewFile();
		if(!supportOutput.exists()) supportOutput.createNewFile();
		
		FileReader fileReader = new FileReader(fileRead);
		FileOutputStream fileOutputStream = new FileOutputStream(fileCopy, true);
		FileOutputStream supportOutputStream = new FileOutputStream(pathSupport, true);
		String[] arrayString = null;
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int lineCount = 0;
		while((line = bufferedReader.readLine()) != null){
			arrayString = line.split(" ");
			for(int i = 0;i<arrayString.length;i++){
				arrayString[i].trim();
				if(arrayString[i].contains("#")){
					arrayString[i] = "";
					support.put(lineCount, arrayString[i+1]);
					arrayString[i+1] = "";
					break;
				}else{
					if(arrayString[i].substring(0, 2).contains("20")||arrayString[i].substring(0, 2).contains("10")){
						arrayString[i] = arrayString[i].substring(0, 2);
					}else{
						arrayString[i] = arrayString[i].substring(0, arrayString[i].indexOf("0"));
					}
				}
			}
			if(Arrays.toString(arrayString) == null){
				System.out.println(lineCount);
			}
			map.put(lineCount, arrayString);
			lineCount++;
		}
		lineCount = 0;
		
		for(int i = 0;i<map.size();i++){
			for(int j = i;j<map.size();j++){
				if(i!=j&&Arrays.equals(map.get(i), map.get(j))&&map.get(i)!=null&&map.get(j)!=null){
//					System.out.println(map.get(i));
//					System.out.println(Arrays.toString(map.get(i)) + "  " + Arrays.toString(map.get(j)));
//  				System.out.println(support.get(i)+ "  " + support.get(j));
//					System.out.println(support.size());
//					System.out.println(map.size());
//					System.out.println();
					int temp = Integer.parseInt(support.get(i)) + Integer.parseInt(support.get(j));
					support.put(i, String.valueOf(temp));
					support.remove(j);
					map.remove(j);
				}
			}
		}
		
		for(int i = 0;i<map.size();i++){
			if(map.get(i) == null) continue;
			for(int j = 0;j<map.get(i).length;j++){
				if(j != map.get(i).length - 1){
					fileOutputStream.write((map.get(i)[j] + " ").getBytes("UTF-8"));
				}else{
					fileOutputStream.write((map.get(i)[j] + System.getProperty("line.separator")).getBytes("UTF-8"));
				}
			}
			supportOutputStream.write((support.get(i) + System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		bufferedReader.close();
		fileOutputStream.close();
		supportOutputStream.close();
	}
	
//	public static void main(String[] args) throws IOException {
//		String pathRead = "E:\\matrix_3\\pattern_22.txt";
//		String pathCopy = "E:\\matrix_4\\matrix_4_22.txt";
//		String pathSupport = "E:\\matrix_4\\support_22.txt";
//		File fileRead = new File(pathRead);
//		File fileCopy = new File(pathCopy);
//		File supportOutput = new File(pathSupport);
//		
//		HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
//		HashMap<Integer, String> support = new HashMap<Integer, String>();
//		String line = null;
//		
//		if(!fileCopy.exists()) fileCopy.createNewFile();
//		if(!fileRead.exists()) fileRead.createNewFile();
//		if(!supportOutput.exists()) supportOutput.createNewFile();
//		
//		FileReader fileReader = new FileReader(fileRead);
//		FileOutputStream fileOutputStream = new FileOutputStream(fileCopy, true);
//		FileOutputStream supportOutputStream = new FileOutputStream(pathSupport, true);
//		String[] arrayString = null;
//		
//		BufferedReader bufferedReader = new BufferedReader(fileReader);
//		int lineCount = 0;
//		while((line = bufferedReader.readLine()) != null){
//			arrayString = line.split(" ");
//			for(int i = 0;i<arrayString.length;i++){
//				arrayString[i].trim();
//				if(arrayString[i].contains("#")){
//					arrayString[i] = "";
//					support.put(lineCount, arrayString[i+1]);
//					arrayString[i+1] = "";
//					break;
//				}else{
//					if(arrayString[i].substring(0, 2).contains("20")||arrayString[i].substring(0, 2).contains("10")){
//						arrayString[i] = arrayString[i].substring(0, 2);
//					}else{
//						arrayString[i] = arrayString[i].substring(0, arrayString[i].indexOf("0"));
//					}
//				}
//			}
//			if(Arrays.toString(arrayString) == null){
//				System.out.println(lineCount);
//			}
//			map.put(lineCount, arrayString);
//			lineCount++;
//		}
//		lineCount = 0;
//		
//		for(int i = 0;i<map.size();i++){
//			for(int j = i;j<map.size();j++){
//				if(i!=j&&Arrays.equals(map.get(i), map.get(j))&&map.get(i)!=null&&map.get(j)!=null){
////					System.out.println(map.get(i));
////					System.out.println(Arrays.toString(map.get(i)) + "  " + Arrays.toString(map.get(j)));
////  				System.out.println(support.get(i)+ "  " + support.get(j));
////					System.out.println(support.size());
////					System.out.println(map.size());
////					System.out.println();
//					int temp = Integer.parseInt(support.get(i)) + Integer.parseInt(support.get(j));
//					support.put(i, String.valueOf(temp));
//					support.remove(j);
//					map.remove(j);
//				}
//			}
//		}
//		
//		for(int i = 0;i<map.size();i++){
//			if(map.get(i) == null) continue;
//			for(int j = 0;j<map.get(i).length;j++){
//				if(j != map.get(i).length - 1){
//					fileOutputStream.write((map.get(i)[j] + " ").getBytes("UTF-8"));
//				}else{
//					fileOutputStream.write((map.get(i)[j] + System.getProperty("line.separator")).getBytes("UTF-8"));
//				}
//			}
//			supportOutputStream.write((support.get(i) + System.getProperty("line.separator")).getBytes("UTF-8"));
//		}
//		bufferedReader.close();
//		fileOutputStream.close();
//		supportOutputStream.close();
//	}
}
