package com.nju.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CutBySpace {
	
	private String pathRead = null;
	private String pathDetailCases = null;
	private String pathSerial = null;
	private String pathPenalize = null;
	private String pathProvision = null;
	
	private File fileRead = null;
	private File fileDetailCasesCopy = null;
	private File fileSerialCopy = null;
	private File filePenalizeCopy = null;
	private File fileProvisionCopy = null;
	
	private FileReader fileReader = null;
	private BufferedReader bufferedReader = null;
	FileOutputStream fileDetailCasesOutput = null;
	FileOutputStream fileSerialOutput = null;
	FileOutputStream filePenalizeOutput = null;
	FileOutputStream fileProvisionOutput = null;
	
	ArrayList<String[]> allTrainData = new ArrayList<String[]>();
	ArrayList<String> serial = new ArrayList<String>();
	ArrayList<String> detailCases = new ArrayList<String>();
	ArrayList<String> penalize = new ArrayList<String>();
	ArrayList<String> provision = new ArrayList<String>();
	
	public CutBySpace(String pathRead, String pathDetailCases, String pathSerial, String pathPenalize, String pathProvision) throws IOException{
		this.pathRead = pathRead;
		this.pathDetailCases = pathDetailCases;
		this.pathSerial = pathSerial;
		this.pathPenalize = pathPenalize;
		this.pathProvision = pathProvision;
		
		fileRead = new File(pathRead);
		fileDetailCasesCopy = new File(pathDetailCases);
		fileSerialCopy = new File(pathSerial);
		filePenalizeCopy = new File(pathPenalize);
		fileProvisionCopy = new File(pathProvision);
		if(!fileDetailCasesCopy.exists()) fileDetailCasesCopy.createNewFile();
		if(!fileSerialCopy.exists()) fileSerialCopy.createNewFile();
		if(!filePenalizeCopy.exists()) filePenalizeCopy.createNewFile();
		if(!fileProvisionCopy.exists()) fileProvisionCopy.createNewFile();
		fileReader = new FileReader(fileRead);
		bufferedReader = new BufferedReader(fileReader);
		fileDetailCasesOutput = new FileOutputStream(fileDetailCasesCopy);
		fileSerialOutput = new FileOutputStream(fileSerialCopy);
		filePenalizeOutput = new FileOutputStream(filePenalizeCopy);
		fileProvisionOutput = new FileOutputStream(fileProvisionCopy);
	}
	
	public CutBySpace(){}
	
	public void Cut() throws IOException{
		String line = null;
		while((line = bufferedReader.readLine())!=null){
			String[] lineTemp = line.split("s+");
			System.out.println(lineTemp.length);
			allTrainData.add(lineTemp);
			serial.add(lineTemp[0]);
			detailCases.add(lineTemp[1]);
			penalize.add(lineTemp[2]);
			provision.add(lineTemp[3]);
		}
	}
	
	public void Output() throws UnsupportedEncodingException, IOException{
		
		for(int i = 0;i<detailCases.size();i++){
			fileDetailCasesOutput.write(detailCases.get(i).getBytes("UTF-8"));
			fileDetailCasesOutput.write(System.getProperty("line.separator").getBytes());
			fileSerialOutput.write(serial.get(i).getBytes("UTF-8"));
			fileSerialOutput.write(System.getProperty("line.separator").getBytes());
			filePenalizeOutput.write(penalize.get(i).getBytes("UTF-8"));
			filePenalizeOutput.write(System.getProperty("line.separator").getBytes());
			fileProvisionOutput.write(provision.get(i).getBytes("UTF-8"));
			fileProvisionOutput.write(System.getProperty("line.separator").getBytes());
		}
		
		
		
	}
	
}
