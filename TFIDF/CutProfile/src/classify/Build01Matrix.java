package classify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Build01Matrix {
	private String pathRead = null;
	private String pathCopy = null;
	
	public Build01Matrix(String pathRead, String pathCopy) {
		this.pathRead = pathRead;
		this.pathCopy = pathCopy;
	}
	
	public void Build() throws IOException{
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		FileReader fileReader = new FileReader(fileRead);
		FileOutputStream fileOutputStream = new FileOutputStream(fileCopy);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		int[] matrixLine = null;
		String line = null;
		int maxNumber = -1;
		//找到最大的属性数字
		while((line = bufferedReader.readLine())!=null){
			String[] lineSplit = null;
			lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				if((Integer.parseInt(lineSplit[i]))>maxNumber) maxNumber = Integer.parseInt(lineSplit[i]);
			}
		}
		bufferedReader.close();
		//建立个一最大的数组，用来作输出
		matrixLine = new int[maxNumber + 1];
		Arrays.fill(matrixLine, 0);
		FileReader fileReader2 = new FileReader(fileRead);
		BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
		while((line = bufferedReader2.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				matrixLine[Integer.parseInt(lineSplit[i])] = 1;
			}
			
			for(int i = 0;i<matrixLine.length;i++){
				if(i!=(matrixLine.length - 1)){
					fileOutputStream.write((matrixLine[i] + " ").getBytes("UTF-8"));
				}else{
					fileOutputStream.write((matrixLine[i] + System.getProperty("line.separator")).getBytes("UTF-8"));
				}
			}
			Arrays.fill(matrixLine, 0);
		}
		bufferedReader2.close();
		fileOutputStream.close();
	}
	
}
