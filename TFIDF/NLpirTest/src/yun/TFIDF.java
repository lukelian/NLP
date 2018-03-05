package yun;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Demo.CalTFIDF;

public class TFIDF {
	
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		
		String[] wordbagList = getFileName("D:\\研究生\\23.云计算大作业\\数据预处理1\\wordbag_n_adj");
		
		String[] commodityList = getFileName("D:\\研究生\\23.云计算大作业\\数据预处理1\\word_all_n_adj");
		
		for(int i = 0;i<wordbagList.length;i++){
			CalTFIDF tfidf = new CalTFIDF();
			ArrayList<ArrayList<String>> tf = new ArrayList<ArrayList<String>>();
			ArrayList<String> idf = new ArrayList<String>();
			String pathAttribute = "D:\\研究生\\23.云计算大作业\\数据预处理1\\wordbag_n_adj\\" + wordbagList[i];
			String pathSingleArticle = "D:\\研究生\\23.云计算大作业\\数据预处理1\\word_all_n_adj\\" + commodityList[i];
			String pathMatrixSingleArticle = "D:\\研究生\\23.云计算大作业\\数据预处理1\\tf_n_adj\\" + wordbagList[i];
			String pathTFIDF = "D:\\研究生\\23.云计算大作业\\数据预处理1\\tfidf_n_adj\\" + wordbagList[i];
			tf = tfidf.TF(pathAttribute, pathSingleArticle, pathMatrixSingleArticle);
			idf = tfidf.IDF();
			tfidf.TFIDF(pathTFIDF);
		}
		
		
		
	}
}
