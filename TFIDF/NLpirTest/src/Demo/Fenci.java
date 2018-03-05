package Demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import nlp_interface.CLibrary;

import com.sun.jna.Native;

public class Fenci {
	
	private String pathDetailCases = null;
	private String pathDetailCasesCopy = null;
	private File fileDetailCases = null;
	private File fileDetailCasesCopy = null;
	private FileInputStream readerDetailCases = null;
	private InputStreamReader streamReaderDetailCases = null;
	private BufferedReader buffReaderDetailCases = null;
	private FileOutputStream fileDetailCasesOutputStream = null;
	
	ArrayList<String> allCases = new ArrayList<String>();
	
	
	public Fenci(String pathDetailCases, String pathDetailCasesCopy) throws IOException{
		
		this.pathDetailCases = pathDetailCases;
		this.pathDetailCasesCopy = pathDetailCasesCopy;
		fileDetailCases = new File(pathDetailCases);
		readerDetailCases = new FileInputStream(fileDetailCases);
		streamReaderDetailCases = new InputStreamReader(readerDetailCases, "UTF-8");
		buffReaderDetailCases = new BufferedReader(streamReaderDetailCases);
		fileDetailCasesCopy = new File(pathDetailCasesCopy);
		fileDetailCasesOutputStream = new FileOutputStream(fileDetailCasesCopy);
		String line = null;
	}
	
	public void Run() throws IOException{
		CLibrary instance = (CLibrary)Native.loadLibrary(System.getProperty("user.dir")+"\\source\\NLPIR", CLibrary.class);
		if(!fileDetailCasesCopy.exists()) fileDetailCasesCopy.createNewFile();
		String resultString = null;
		int init_flag = instance.NLPIR_Init("", 1, "0");
		if(0 == init_flag){
			resultString = instance.NLPIR_GetLastErrorMsg();
			System.err.println("≥ı ºªØ ß∞‹£°\n"+resultString);
			return;
		}
		instance.NLPIR_FileProcess(pathDetailCases, pathDetailCasesCopy, 1);
		
		this.buffReaderDetailCases.close();
		this.fileDetailCasesOutputStream.close();
		
	}
	
	
//	public static void main(String[] args) throws IOException {
//		String pathDetailCases = "E:\\data\\detail_cases.txt";
//		String pathDetailCasesCopy = "E:\\data\\fenci_all.txt";
//		
//		Fenci fenci = new Fenci(pathDetailCases, pathDetailCasesCopy);
//		
//		fenci.Run();
//		
//	}
	
}
