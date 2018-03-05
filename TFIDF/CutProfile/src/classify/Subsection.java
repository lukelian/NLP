package classify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Subsection {
	
	private static final String[] TYPES = {
			"TYPE_ANNOUNCEMENT",									//1
			"TYPE_ASSIST_READING_CONTEXT",							//2
			"TYPE_GESTURE_DETECTION_END",							//3
			"TYPE_GESTURE_DETECTION_START",							//4
			"TYPE_NOTIFICATION_STATE_CHANGED",						//5
			"TYPE_TOUCH_EXPLORATION_GESTURE_END",					//6
			"TYPE_TOUCH_EXPLORATION_GESTURE_START",					//7
			"TYPE_TOUCH_INTERACTION_END",							//8
			"TYPE_TOUCH_INTERACTION_START",							//9
			"TYPE_VIEW_ACCESSIBILITY_FOCUSED",						//10
			"TYPE_VIEW_ACCESSIBILITY_FOCUSED_CLEARED",				//11
			"TYPE_VIEW_CLICKED",									//12
			"TYPE_VIEW_CONTEXT_CLICKED",							//13
			"TYPE_VIEW_FOCUSED",									//14
			"TYPE_VIEW_HOVER_ENTER",								//15
			"TYPE_VIEW_HOVER_EXIT",									//16
			"TYPE_VIEW_LONG_CLICKED",								//17
			"TYPE_VIEW_SCROLLED",									//18
			"TYPE_VIEW_SELECTED",									//19
			"TYPE_VIEW_TEXT_CHANGED",								//20
			"TYPE_VIEW_TEXT_SELECTION_CHANGED",						//21
			"TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY",		//22
			"TYPE_WINDOWS_CHANGED",									//23
			"TYPE_WINDOW_CONTENT_CHANGED",							//24
			"TYPE_WINDOW_STATE_CHANGED"};							//25
	
//	String readPath = "E:\\SE-1800移动APP";
//	String copyPath = "E:\\stage_1";
//	String matrixPath = "E:\\matrix_1";
//	String matrixNonLossPath = "E:\\matrix_2";
	
	private String readPath = null;
	private String copyPath = null;
	private String matrixPath = null;
	private String matrixNonLossPath = null;
	
	public Subsection(String pathScatterFile, String pathSplitActivityColumn, String pathSingleMatrix, String pathSplitActivityLine) {
		this.readPath = pathScatterFile;
		this.copyPath = pathSplitActivityColumn;
		this.matrixPath = pathSingleMatrix;
		this.matrixNonLossPath = pathSplitActivityLine;
	}
	
	public static String repeat(String str, int n) {
	    String result = str;
	    for(int i = 0; i< n; i++) {
	       result = result.concat(str);
	    }
	    return result;
	}
	
	public void BuildActivity() throws IOException{
		File fileRoot = new File(readPath);
		
		FileOutputStream fileOutputStream = null;
		FileOutputStream matrixOutputStream = null;
		FileOutputStream matrixNonLossOutputStream = null;
		FileInputStream fileInputStream = null;
		
		File fileMatrix = new File(matrixPath);
		File fileMatrixNonLoss = new File(matrixNonLossPath);
		
		if(!fileMatrix.exists()) fileMatrix.createNewFile();
		if(!fileMatrixNonLoss.exists()) fileMatrixNonLoss.createNewFile();
		
		int[] matrixLine = new int[25];
		Arrays.fill(matrixLine, 0);

//		Object[] matrixLineTemp = new Object[25];
//		HashMap<Object, Object> matrixLine = new HashMap<Object, Object>();
		
		String[] fileList = fileRoot.list();
		for(int i = 0;i<fileList.length;i++){
			File fileRead = new File(readPath + "\\" + fileList[i]);
			File fileCopy = new File(copyPath + "\\" + fileList[i]);
			
			
			//如果文件不存在的话就要创建
			if(!fileCopy.exists()) fileCopy.createNewFile();
			
//			String space = "  ";
			try {
				FileReader fileReader = new FileReader(fileRead);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = null;
				String lineTemp = null;
				String matrixNonLossLine = null;
//				String matrixLine = "";
				while((line = bufferedReader.readLine())!=null){
					for(int j = 0;j<TYPES.length;j++){
						
						if(line.contains(TYPES[j])){//如果包含了某个type，则给这行打上type的标签
							//构造01矩阵
							matrixLine[j] = 1;
							//一行结束后要换行
							matrixNonLossLine = String.valueOf(j + 1) + " ";
							lineTemp = String.valueOf(j) + System.getProperty("line.separator");
							if(line.contains("Activity")){
								//如果包含activity，则要空一行
								matrixNonLossLine = matrixNonLossLine + System.getProperty("line.separator");
								lineTemp = lineTemp + System.getProperty("line.separator");
								matrixOutputStream = new FileOutputStream(fileMatrix,true);
								
								for(int k = 0;k<matrixLine.length;k++){
									//输出01矩阵到文件
									matrixOutputStream.write((String.valueOf(matrixLine[k]) + "  ").getBytes());
								}
								Arrays.fill(matrixLine, 0);
								//一行结束后输出一个换行符
								matrixOutputStream.write(System.getProperty("line.separator").getBytes());
							}
							
							//输出分割后的activity序列到文件
							fileOutputStream = new FileOutputStream(fileCopy, true);
							fileOutputStream.write(lineTemp.getBytes("UTF-8"));
							fileOutputStream.close();
							
							//输出无损失activity矩阵
							matrixNonLossOutputStream = new FileOutputStream(fileMatrixNonLoss,true);
							matrixNonLossOutputStream.write(matrixNonLossLine.getBytes("UTF-8"));
							
							break;
						}
					}
				}
				if(!matrixNonLossLine.contains("25")){
					matrixNonLossOutputStream.write(System.getProperty("line.separator").getBytes());
				}
				if(!lineTemp.contains("24")){
					matrixOutputStream = new FileOutputStream(fileMatrix,true);
					for(int k = 0;k<matrixLine.length;k++){
						matrixOutputStream.write((String.valueOf(matrixLine[k]) + "  ").getBytes());
					}
					Arrays.fill(matrixLine, 0);
					matrixOutputStream.write(System.getProperty("line.separator").getBytes());
				}
				bufferedReader.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("找不到文件！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("读取失败！");
			}
			fileOutputStream.close();
		}
		matrixOutputStream.close();
		matrixNonLossOutputStream.close();
	}
	
//	public static void main(String[] args) throws IOException {
//		
//		
//		File fileRoot = new File(readPath);
//		
//		FileOutputStream fileOutputStream = null;
//		FileOutputStream matrixOutputStream = null;
//		FileOutputStream matrixNonLossOutputStream = null;
//		FileInputStream fileInputStream = null;
//		
//		File fileMatrix = new File(matrixPath + "\\" + "matrix_1.txt");
//		File fileMatrixNonLoss = new File(matrixNonLossPath + "\\" + "matrix_2.txt");
//		
//		if(!fileMatrix.exists()) fileMatrix.createNewFile();
//		if(!fileMatrixNonLoss.exists()) fileMatrixNonLoss.createNewFile();
//		
//		int[] matrixLine = new int[25];
//		Arrays.fill(matrixLine, 0);
//
////		Object[] matrixLineTemp = new Object[25];
////		HashMap<Object, Object> matrixLine = new HashMap<Object, Object>();
//		
//		String[] fileList = fileRoot.list();
//		for(int i = 0;i<fileList.length;i++){
//			File fileRead = new File(readPath + "\\" + fileList[i]);
//			File fileCopy = new File(copyPath + "\\" + fileList[i]);
//			
//			
//			//如果文件不存在的话就要创建
//			if(!fileCopy.exists()) fileCopy.createNewFile();
//			
////			String space = "  ";
//			try {
//				FileReader fileReader = new FileReader(fileRead);
//				BufferedReader bufferedReader = new BufferedReader(fileReader);
//				String line = null;
//				String lineTemp = null;
//				String matrixNonLossLine = null;
////				String matrixLine = "";
//				while((line = bufferedReader.readLine())!=null){
//					for(int j = 0;j<TYPES.length;j++){
//						
//						if(line.contains(TYPES[j])){//如果包含了某个type，则给这行打上type的标签
//							//构造01矩阵
//							matrixLine[j] = 1;
//							//一行结束后要换行
//							matrixNonLossLine = String.valueOf(j + 1) + " ";
//							lineTemp = String.valueOf(j) + System.getProperty("line.separator");
//							if(line.contains("Activity")){
//								//如果包含activity，则要空一行
//								matrixNonLossLine = matrixNonLossLine + System.getProperty("line.separator");
//								lineTemp = lineTemp + System.getProperty("line.separator");
//								matrixOutputStream = new FileOutputStream(fileMatrix,true);
//								
//								for(int k = 0;k<matrixLine.length;k++){
//									//输出01矩阵到文件
//									matrixOutputStream.write((String.valueOf(matrixLine[k]) + "  ").getBytes());
//								}
//								Arrays.fill(matrixLine, 0);
//								//一行结束后输出一个换行符
//								matrixOutputStream.write(System.getProperty("line.separator").getBytes());
//							}
//							
//							//输出分割后的activity序列到文件
//							fileOutputStream = new FileOutputStream(fileCopy, true);
//							fileOutputStream.write(lineTemp.getBytes("UTF-8"));
//							fileOutputStream.close();
//							
//							//输出无损失activity矩阵
//							matrixNonLossOutputStream = new FileOutputStream(fileMatrixNonLoss,true);
//							matrixNonLossOutputStream.write(matrixNonLossLine.getBytes("UTF-8"));
//							
//							break;
//						}
//					}
//				}
//				if(!matrixNonLossLine.contains("25")){
//					matrixNonLossOutputStream.write(System.getProperty("line.separator").getBytes());
//				}
//				if(!lineTemp.contains("24")){
//					matrixOutputStream = new FileOutputStream(fileMatrix,true);
//					for(int k = 0;k<matrixLine.length;k++){
//						matrixOutputStream.write((String.valueOf(matrixLine[k]) + "  ").getBytes());
//					}
//					Arrays.fill(matrixLine, 0);
//					matrixOutputStream.write(System.getProperty("line.separator").getBytes());
//				}
//				bufferedReader.close();
//				
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				System.out.println("找不到文件！");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				System.out.println("读取失败！");
//			}
//			fileOutputStream.close();
//		}
//		matrixOutputStream.close();
//		matrixNonLossOutputStream.close();
//		
//	}
}
