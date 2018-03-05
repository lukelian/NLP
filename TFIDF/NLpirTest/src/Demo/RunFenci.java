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

public class RunFenci {
	
	public static void main(String[] args) throws IOException {
		
//		String pathDetailCases = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset_split\\detail_all.txt";
//		String pathDetailCasesCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\fenci_all.txt";
		
		String pathDetailCases = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\law\\law_detail.txt";
		String pathDetailCasesCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\law\\law_detail_fenci.txt";
		File fileDetailCasesCopy = new File(pathDetailCasesCopy);
		
		if(!fileDetailCasesCopy.exists()) fileDetailCasesCopy.createNewFile();
		Fenci fenci = new Fenci(pathDetailCases,pathDetailCasesCopy);
		fenci.Run();
//		String resultString = null;
//		int init_flag = instance.NLPIR_Init("", 1, "0");
//		if(0 == init_flag){
//			resultString = instance.NLPIR_GetLastErrorMsg();
//			System.err.println("≥ı ºªØ ß∞‹£°\n"+resultString);
//			return;
//		}
		
		
		
	}
}
