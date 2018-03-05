import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FasttextLabelResult {
	public static void main(String[] args) throws IOException {
		String pathRead = "D:\\研究生\\28.类案推荐论文\\result\\fasttext_result.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\result\\fasttext_format_result.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		String pattern = ".*(\\d).*";
		Pattern r = Pattern.compile(pattern);
		while((line = buff.readLine())!=null){
			Matcher m = r.matcher(line);
			String lineTemp = "";
			if(m.find()){
				lineTemp = m.group(1);
			}
			System.out.println(lineTemp);
			fileOut.write(lineTemp.getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		buff.close();
		fileOut.close();
	}
}
