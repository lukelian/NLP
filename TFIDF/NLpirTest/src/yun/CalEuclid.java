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
		
		String[] commodityList = getFileName("D:\\研究生\\23.云计算大作业\\数据预处理1\\tfidf_n_adj");
		for(int i = 0;i<commodityList.length;i++){
			String pathTestMatrix = "D:\\研究生\\23.云计算大作业\\数据预处理1\\tfidf_n_adj\\" + commodityList[i];
			String pathDistanceMatrix = "D:\\研究生\\23.云计算大作业\\数据预处理1\\distance_n_adj\\" + commodityList[i];
			Euclid euclid = new Euclid(pathTestMatrix, pathDistanceMatrix);
			
			euclid.DistanceCal();
		}
		
		
		
	}
}
