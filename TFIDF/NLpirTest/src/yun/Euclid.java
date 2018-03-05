package yun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Euclid {
	
	private String pathTestMatrix = null;
	private String pathDistanceMatrix = null;
	private ArrayList<ArrayList<String>> distanceMatrix = new ArrayList<ArrayList<String>>();
	
	public Euclid(String pathTestMatrix, String pathDistanceMatrix){
		this.pathTestMatrix = pathTestMatrix;
		this.pathDistanceMatrix = pathDistanceMatrix;
	}
	
	public void DistanceCal() throws IOException{
		File fileMatrixTest = new File(pathTestMatrix);
		FileInputStream inputFileTest = new FileInputStream(fileMatrixTest);
		
		InputStreamReader inputStreamTest = new InputStreamReader(inputFileTest);
		BufferedReader buffTestReader = new BufferedReader(inputStreamTest);
		
		String line = null;
		
		ArrayList<String> data = new ArrayList<String>();
		
		while((line = buffTestReader.readLine()) != null){
			data.add(line);
		}
		buffTestReader.close();
		
		for(int i = 0;i<data.size();i++){
			String[] lineSplitPro = data.get(i).split(" ");
			ArrayList<String> listDistance = new ArrayList<String>();
			for(int j = 0;j<data.size();j++){
				String[] lineSplitAfter = data.get(j).split(" ");
				double temp = 0.0;
				for(int k = 0;k<lineSplitAfter.length;k++){
					if(!lineSplitPro[k].equals("0")||!lineSplitAfter[k].equals("0")){
						temp = temp + Math.abs(Math.pow(Sigmoid(lineSplitPro[k]),2) - Math.pow(Sigmoid(lineSplitAfter[k]), 2));
					}
				}
				listDistance.add(String.valueOf(temp));
			}
			this.distanceMatrix.add(listDistance);
		}
		
		File fileDistance = new File(pathDistanceMatrix);
		if(!fileDistance.exists()) fileDistance.createNewFile();
		FileOutputStream fileDistanceOutStream = new FileOutputStream(fileDistance);
		int articleNum = this.distanceMatrix.size();
		for(int i = 0;i<articleNum;i++){
			for(int j = 0;j<articleNum;j++){
				fileDistanceOutStream.write((this.distanceMatrix.get(i).get(j) + " ").getBytes("UTF-8"));
			}
			fileDistanceOutStream.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		fileDistanceOutStream.close();
	}
	
	
	
	public double Sigmoid(String num){
		double x = Double.valueOf(num);
		double sigmoid = 1/(1 + Math.exp(-x));
		return sigmoid;
	}
	

}
