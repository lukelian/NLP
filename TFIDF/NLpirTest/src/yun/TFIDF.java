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
		
		String[] wordbagList = getFileName("D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\wordbag_n_adj");
		
		String[] commodityList = getFileName("D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\word_all_n_adj");
		
		for(int i = 0;i<wordbagList.length;i++){
			CalTFIDF tfidf = new CalTFIDF();
			ArrayList<ArrayList<String>> tf = new ArrayList<ArrayList<String>>();
			ArrayList<String> idf = new ArrayList<String>();
			String pathAttribute = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\wordbag_n_adj\\" + wordbagList[i];
			String pathSingleArticle = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\word_all_n_adj\\" + commodityList[i];
			String pathMatrixSingleArticle = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\tf_n_adj\\" + wordbagList[i];
			String pathTFIDF = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\tfidf_n_adj\\" + wordbagList[i];
			tf = tfidf.TF(pathAttribute, pathSingleArticle, pathMatrixSingleArticle);
			idf = tfidf.IDF();
			tfidf.TFIDF(pathTFIDF);
		}
		
		
		
	}
}
