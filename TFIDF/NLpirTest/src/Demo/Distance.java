package Demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Distance {
	private String pathTrainMatrix = "D:\\data\\matrix_single_article3.txt";
	private String pathTestMatrix = "D:\\data\\matrix_test_single_article.txt";
	
	private ArrayList<String> listLocate = new ArrayList<String>();
	
	public Distance(String pathTrainMatrix, String pathTestMatrix){
		this.pathTrainMatrix = pathTrainMatrix;
		this.pathTestMatrix = pathTestMatrix;
	}
	
	public ArrayList<String> DistanceCal() throws IOException{
		File fileMatrixTest = new File(pathTestMatrix);
		FileInputStream inputFileTest = new FileInputStream(fileMatrixTest);
		
		InputStreamReader inputStreamTest = new InputStreamReader(inputFileTest);
		BufferedReader buffTestReader = new BufferedReader(inputStreamTest);
		
		String lineTrain = null;
		String lineTest = null;

		while((lineTest = buffTestReader.readLine()) != null){
			String[] lineTestSplit = lineTest.split(" ");
			File fileMatrixTrain = new File(pathTrainMatrix);
			FileInputStream inputFileTrain = new FileInputStream(fileMatrixTrain);
			InputStreamReader inputStreamTrain = new InputStreamReader(inputFileTrain);
			BufferedReader buffTrainReader = new BufferedReader(inputStreamTrain);
			ArrayList<String> listDistance = new ArrayList<String>();
			//是正确的？
			double temp = 0.0;
			while((lineTrain = buffTrainReader.readLine()) != null){
				String[] lineTrainSplit = lineTrain.split(" ");
				//是错误的？
//				double temp = 0.0;
					for(int i = 0;i<lineTrainSplit.length;i++){
						if(!lineTestSplit[i].equals("0")||!lineTrainSplit[i].equals("0")){
							temp = temp + Math.abs(Math.pow(Sigmoid(lineTrainSplit[i]),2) - Math.pow(Sigmoid(lineTestSplit[i]), 2));
						}
					}
					listDistance.add(String.valueOf(temp));
			}
			int maxLocation = -1;
			double max = -1.0;
			for(int i = 0;i<listDistance.size();i++){
				if(max<Double.valueOf(listDistance.get(i))){
					max = Double.valueOf(listDistance.get(i));
					maxLocation = i;
				}
			}
			System.out.println(listDistance.get(1697));
			listLocate.add(String.valueOf(maxLocation));
			buffTrainReader.close();
		}
		
		buffTestReader.close();
		return listLocate;
		
	}
	
	
	
	public double Sigmoid(String num){
		
		int x = Integer.parseInt(num);
		double sigmoid = 1/(1 + Math.exp(-x));
		
		return sigmoid;
	}
	
}
