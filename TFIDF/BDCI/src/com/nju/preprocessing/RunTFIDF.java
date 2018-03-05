package com.nju.preprocessing;

import java.io.IOException;

public class RunTFIDF {
	
	
	
	public static void main(String[] args) throws IOException {
//		String pathAttribute = "D:\\研究生\\20.CCF比赛\\wordbag\\wordbag.txt";
//		String pathSingleArticle = "D:\\研究生\\20.CCF比赛\\detail\\detail_all_fenci_without_cixing.txt";
//		String pathMatrixSingleArticle = "D:\\研究生\\20.CCF比赛\\tfidf\\tf.txt";
//		String idfMatrix = "D:\\研究生\\20.CCF比赛\\tfidf\\idf.txt";
//		String tfidfMatrix = "D:\\研究生\\20.CCF比赛\\tfidf\\tfidf.txt";
//		String attributeOrder = "D:\\研究生\\20.CCF比赛\\卡方检验\\wordbag_order\\6000_10000.txt";
		
		String pathAttribute = "D:\\研究生\\20.CCF比赛\\卡方检验_test\\10000\\1000_without_characters.txt";
		String pathSingleArticle = "D:\\研究生\\20.CCF比赛\\detail\\detail_all_fenci_without_cixing.txt";
		String pathMatrixSingleArticle = "D:\\研究生\\20.CCF比赛\\卡方检验_test\\tfidf\\tf.txt";
		String idfMatrix = "D:\\研究生\\20.CCF比赛\\卡方检验_test\\tfidf\\idf.txt";
		String tfidfMatrix = "D:\\研究生\\20.CCF比赛\\卡方检验_test\\tfidf\\tfidf.txt";
		String attributeOrder = "D:\\研究生\\20.CCF比赛\\卡方检验_test\\wordbag_order\\6000_10000.txt";
		
		CalTFIDF tfidf = new CalTFIDF();
		tfidf.TF(pathAttribute, pathSingleArticle, pathMatrixSingleArticle, attributeOrder);
		tfidf.IDF(idfMatrix);
		tfidf.TFIDF(pathMatrixSingleArticle, tfidfMatrix);
//		tfidf.TFIDF(tfidfMatrix);
	}

}
