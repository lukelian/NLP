package yun;

import java.io.File;
import java.io.IOException;

public class CalEuclid {
	
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		
		String[] commodityList = getFileName("D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\tfidf_n_adj");
		for(int i = 0;i<commodityList.length;i++){
			String pathTestMatrix = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\tfidf_n_adj\\" + commodityList[i];
			String pathDistanceMatrix = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\distance_n_adj\\" + commodityList[i];
			Euclid euclid = new Euclid(pathTestMatrix, pathDistanceMatrix);
			
			euclid.DistanceCal();
		}
		
		
		
	}
}
