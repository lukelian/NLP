package Demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nlp_interface.CLibrary;

import com.sun.jna.Native;

public class ReductionByHanzi {
	private static String pathWordBag= "D:\\data\\word_bag_with_cixing.txt";
	private static String pathWordBagReduction = "D:\\data\\word_bag_only_mingci.txt";
	
	public ReductionByHanzi(String pathWordBag, String pathWordBagReduction){
		this.pathWordBag = pathWordBag;
		this.pathWordBagReduction = pathWordBagReduction;
	}
	
	public static boolean isChinese(String str) {
		String regEx = "^[\u4e00-\u9fa5]{0,}$";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find())
			flg = true;

		return flg;
	}
	
	public static void main(String[] args) throws IOException {
		File fileInput = new File(pathWordBag);
		File fileOutput = new File(pathWordBagReduction);
		
		CLibrary instance = (CLibrary)Native.loadLibrary(System.getProperty("user.dir")+"\\source\\NLPIR", CLibrary.class);
		int init_flag = instance.NLPIR_Init("", 1, "0");
		
		if(!fileOutput.exists()) fileOutput.createNewFile();
		FileInputStream streamFileAllCases = new FileInputStream(fileInput);
		FileOutputStream outputFileAllCases = new FileOutputStream(fileOutput);
		InputStreamReader inputReaderAllCases = new InputStreamReader(streamFileAllCases, "UTF-8");
		BufferedReader allCases = new BufferedReader(inputReaderAllCases);
		
		String line = null;
		while((line = allCases.readLine())!=null){
			if(isChinese(line)){
				String fenci_renming = instance.NLPIR_ParagraphProcess(line, 1);
//				if(!fenci_renming.contains("µÄ")&&!fenci_renming.contains("/c")&&!fenci_renming.contains("/d")&&!fenci_renming.contains("/b")&&!fenci_renming.contains("/z")&&!fenci_renming.contains("r")&&!fenci_renming.contains("v")&&!fenci_renming.contains("a")&&!fenci_renming.contains("w")){
				if(fenci_renming.contains("n")&&!fenci_renming.contains("nr")){
					outputFileAllCases.write(fenci_renming.getBytes("UTF-8"));
					outputFileAllCases.write((System.getProperty("line.separator")).getBytes("UTF-8"));
				}
			}
		}
		allCases.close();
		outputFileAllCases.close();
	}
	
}
