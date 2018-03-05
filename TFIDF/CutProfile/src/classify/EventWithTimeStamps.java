package classify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EventWithTimeStamps {
	
	private static int[] TimeMark = new int[200];
	
	private String pathAcitivityLine = null;
	private String pathActivityWithStamps = null;
	
	public EventWithTimeStamps(String pathAcitivityLine, String pathActivityWithStamps) {
		this.pathAcitivityLine = pathAcitivityLine;
		this.pathActivityWithStamps = pathActivityWithStamps;
	}
	
	public void EventAppendTimeStamps(){
		Arrays.fill(TimeMark, 0);
		String filePath = pathAcitivityLine;
		String copyPath = pathActivityWithStamps;
		File matrixTxt = new File(filePath);
		File fileCopy = new File(copyPath);
		
//		ArrayList<String[]> arrayStringAll = new ArrayList<String[]>();
		try {
			if(!fileCopy.exists()) fileCopy.createNewFile();
			FileReader fileReader = new FileReader(matrixTxt);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileOutputStream fileOutput = new FileOutputStream(fileCopy, true);
			String line = null;
			String lineWrite = null;
			String[] arrayString = null;
			int[][] array = null;
			while((line = bufferedReader.readLine())!=null){
				arrayString = line.split(" ");
				int temp = 0;
				for(int i = 0;i<arrayString.length;i++){
					arrayString[i].trim();
					temp = ++TimeMark[Integer.parseInt(arrayString[i])];
					arrayString[i] = arrayString[i] + "0" + String.valueOf(temp);
					if(i!=(arrayString.length - 1)){
						lineWrite = arrayString[i] + " ";
					}else{
						lineWrite = arrayString[i];
					}
					fileOutput.write(lineWrite.getBytes("UTF-8"));
				}
//				arrayStringAll.add(arrayString);
				fileOutput.write(System.getProperty("line.separator").getBytes());
				Arrays.fill(TimeMark, 0);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		Arrays.fill(TimeMark, 0);
//		String filePath = "E:\\matrix_2\\matrix_2.txt";
//		String copyPath = "E:\\matrix_3\\matrix_3.txt";
//		File matrixTxt = new File(filePath);
//		File fileCopy = new File(copyPath);
//		
////		ArrayList<String[]> arrayStringAll = new ArrayList<String[]>();
//		try {
//			if(!fileCopy.exists()) fileCopy.createNewFile();
//			FileReader fileReader = new FileReader(matrixTxt);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			FileOutputStream fileOutput = new FileOutputStream(fileCopy, true);
//			String line = null;
//			String lineWrite = null;
//			String[] arrayString = null;
//			int[][] array = null;
//			while((line = bufferedReader.readLine())!=null){
//				arrayString = line.split(" ");
//				int temp = 0;
//				for(int i = 0;i<arrayString.length;i++){
//					arrayString[i].trim();
//					temp = ++TimeMark[Integer.parseInt(arrayString[i])];
//					arrayString[i] = arrayString[i] + "0" + String.valueOf(temp);
//					if(i!=(arrayString.length - 1)){
//						lineWrite = arrayString[i] + " ";
//					}else{
//						lineWrite = arrayString[i];
//					}
//					fileOutput.write(lineWrite.getBytes("UTF-8"));
//				}
////				arrayStringAll.add(arrayString);
//				fileOutput.write(System.getProperty("line.separator").getBytes());
//				Arrays.fill(TimeMark, 0);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
