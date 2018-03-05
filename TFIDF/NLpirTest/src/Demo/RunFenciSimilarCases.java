package Demo;

import java.io.File;
import java.io.IOException;

public class RunFenciSimilarCases {
	public static void main(String[] args) throws IOException {
		String pathDetail = "D:\\�о���\\28.�స�Ƽ�����\\dataset\\union_cases_detail.txt";
		String pathYear = "D:\\�о���\\28.�స�Ƽ�����\\dataset\\year_dic.txt";
		String pathCrime = "D:\\�о���\\28.�స�Ƽ�����\\dataset\\crime_dic.txt";
		String pathLocation = "D:\\�о���\\28.�స�Ƽ�����\\dataset\\location_dic.txt";
		String pathResult = "D:\\�о���\\28.�స�Ƽ�����\\fenci\\fenci.txt";
		
		File fileResult = new File(pathResult);
		if(!fileResult.exists()) fileResult.createNewFile();
		FenciSimilarCases fc = new FenciSimilarCases(pathDetail, pathResult, pathYear, pathCrime, pathLocation);
		fc.Run();
		
	}
}
