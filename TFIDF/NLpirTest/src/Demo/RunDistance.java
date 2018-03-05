package Demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RunDistance {
	public static void main(String[] args) throws IOException {
		ArrayList<String> similarityLocate = new ArrayList<String>();
		
		String pathTrainMatrix = "D:\\data\\matrix_single_article3.txt";
		String pathTestMatrix = "D:\\data\\matrix_test_single_article.txt";
		
		Distance distance = new Distance(pathTrainMatrix, pathTestMatrix);
		similarityLocate = distance.DistanceCal();
		
		String output = "D:\\data\\similarity3.txt";
		File fileOutput = new File(output);
		if(!fileOutput.exists()) fileOutput.createNewFile();
		FileOutputStream outputStream = new FileOutputStream(fileOutput);
		for(int i = 0;i<similarityLocate.size();i++){
			outputStream.write(similarityLocate.get(i).getBytes("UTF-8"));
			outputStream.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
	}
}
