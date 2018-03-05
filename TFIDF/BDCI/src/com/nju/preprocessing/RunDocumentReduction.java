package com.nju.preprocessing;

import java.io.IOException;

public class RunDocumentReduction {
	
	public static void main(String[] args) throws IOException {
		
		String pathDocumentFenci = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\fenci_all_reduction_by_cixing.txt";
		String pathWordBag = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\lda\\model_02000_keywords_1000.txt";
		String pathDocumentReduction = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\lda\\document_reduction_1000.txt";
		
//		String pathDocumentFenci = "D:\\�о���\\20.CCF����\\detail\\detail_all_fenci_without_cixing.txt";
//		String pathWordBag = "D:\\�о���\\20.CCF����\\final\\wordbag_canuse\\8000_40000.txt";
//		String pathDocumentReduction = "D:\\�о���\\20.CCF����\\final\\detail_reduction\\detail_reduction_with_preprocessing.txt";
		
		DocumentReduction dr = new DocumentReduction(pathWordBag, pathDocumentFenci, pathDocumentReduction);
		dr.Cal();
	}
	
}
