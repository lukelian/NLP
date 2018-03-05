package Demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import nlp_interface.CLibrary;

import com.sun.jna.Native;

public class FenciSimilarCases {
	private String pathDetailCases = null;
	private String pathDetailCasesCopy = null;
	private String pathYear = null;
	private String pathCrime = null;
	private String pathLocation = null;
	
	private File fileDetailCases = null;
	private File fileDetailCasesCopy = null;
	private File fileYear = null;
	private File fileCrime = null;
	private File fileLocation = null;
	
	private FileInputStream readerDetailCases = null;
	private InputStreamReader streamReaderDetailCases = null;
	private BufferedReader buffReaderDetailCases = null;
	private FileOutputStream fileDetailCasesOutputStream = null;
	private BufferedReader buffYear = null;
	private BufferedReader buffCrime = null;
	private BufferedReader buffLocation = null;
	
	ArrayList<String> allCases = new ArrayList<String>();
	
	
	public FenciSimilarCases(String pathDetailCases, String pathDetailCasesCopy, String pathYear, String pathCrime, String pathLocation) throws IOException{
		
		this.pathDetailCases = pathDetailCases;
		this.pathDetailCasesCopy = pathDetailCasesCopy;
		this.pathYear = pathYear;
		this.pathCrime = pathCrime;
		this.pathLocation = pathLocation;
		
		this.fileYear = new File(this.pathYear);
		this.fileCrime = new File(this.pathCrime);
		this.fileLocation = new File(this.pathLocation);
		
		this.buffCrime = new BufferedReader(new InputStreamReader(new FileInputStream(fileCrime), "UTF-8"));
		this.buffLocation = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocation), "UTF-8"));
		this.buffYear = new BufferedReader(new InputStreamReader(new FileInputStream(fileYear), "UTF-8"));
		
		fileDetailCases = new File(pathDetailCases);
		readerDetailCases = new FileInputStream(fileDetailCases);
		streamReaderDetailCases = new InputStreamReader(readerDetailCases, "UTF-8");
		buffReaderDetailCases = new BufferedReader(streamReaderDetailCases);
		fileDetailCasesCopy = new File(pathDetailCasesCopy);
		fileDetailCasesOutputStream = new FileOutputStream(fileDetailCasesCopy);
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
		
		String line = null;
		while((line = buffYear.readLine())!=null){
			instance.NLPIR_AddUserWord(line.trim() + " " + "uy");
		}
		
		while((line = buffCrime.readLine())!=null){
			instance.NLPIR_AddUserWord(line.trim() + " " + "un");
		}
		
		while((line = buffLocation.readLine())!=null){
			instance.NLPIR_AddUserWord(line.trim() + " " + "us");
		}
		
		instance.NLPIR_FileProcess(pathDetailCases, pathDetailCasesCopy, 1);
		
		
		this.buffReaderDetailCases.close();
		this.fileDetailCasesOutputStream.close();
		
	}
}
