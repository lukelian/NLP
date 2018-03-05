package com.nju.preprocessing;

import java.io.IOException;

public class RunTFIDF {
	
	
	
	public static void main(String[] args) throws IOException {
//		String pathAttribute = "D:\\�о���\\20.CCF����\\wordbag\\wordbag.txt";
//		String pathSingleArticle = "D:\\�о���\\20.CCF����\\detail\\detail_all_fenci_without_cixing.txt";
//		String pathMatrixSingleArticle = "D:\\�о���\\20.CCF����\\tfidf\\tf.txt";
//		String idfMatrix = "D:\\�о���\\20.CCF����\\tfidf\\idf.txt";
//		String tfidfMatrix = "D:\\�о���\\20.CCF����\\tfidf\\tfidf.txt";
//		String attributeOrder = "D:\\�о���\\20.CCF����\\��������\\wordbag_order\\6000_10000.txt";
		
		String pathAttribute = "D:\\�о���\\20.CCF����\\��������_test\\10000\\1000_without_characters.txt";
		String pathSingleArticle = "D:\\�о���\\20.CCF����\\detail\\detail_all_fenci_without_cixing.txt";
		String pathMatrixSingleArticle = "D:\\�о���\\20.CCF����\\��������_test\\tfidf\\tf.txt";
		String idfMatrix = "D:\\�о���\\20.CCF����\\��������_test\\tfidf\\idf.txt";
		String tfidfMatrix = "D:\\�о���\\20.CCF����\\��������_test\\tfidf\\tfidf.txt";
		String attributeOrder = "D:\\�о���\\20.CCF����\\��������_test\\wordbag_order\\6000_10000.txt";
		
		CalTFIDF tfidf = new CalTFIDF();
		tfidf.TF(pathAttribute, pathSingleArticle, pathMatrixSingleArticle, attributeOrder);
		tfidf.IDF(idfMatrix);
		tfidf.TFIDF(pathMatrixSingleArticle, tfidfMatrix);
//		tfidf.TFIDF(tfidfMatrix);
	}

}
