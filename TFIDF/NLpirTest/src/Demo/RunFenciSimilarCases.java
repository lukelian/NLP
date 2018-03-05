package Demo;

import java.io.File;
import java.io.IOException;

public class RunFenciSimilarCases {
	public static void main(String[] args) throws IOException {
		String pathDetail = "D:\\研究生\\28.类案推荐论文\\dataset\\union_cases_detail.txt";
		String pathYear = "D:\\研究生\\28.类案推荐论文\\dataset\\year_dic.txt";
		String pathCrime = "D:\\研究生\\28.类案推荐论文\\dataset\\crime_dic.txt";
		String pathLocation = "D:\\研究生\\28.类案推荐论文\\dataset\\location_dic.txt";
		String pathResult = "D:\\研究生\\28.类案推荐论文\\fenci\\fenci.txt";
		
		File fileResult = new File(pathResult);
		if(!fileResult.exists()) fileResult.createNewFile();
		FenciSimilarCases fc = new FenciSimilarCases(pathDetail, pathResult, pathYear, pathCrime, pathLocation);
		fc.Run();
		
	}
}
