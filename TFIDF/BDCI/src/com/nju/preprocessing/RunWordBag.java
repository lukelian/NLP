package com.nju.preprocessing;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RunWordBag {
	public static void main(String[] args) throws IOException {
		String pathAllCases = "D:\\�о���\\20.CCF����\\detail\\detail_all_fenci_with_cixing.txt";
		String pathAllCasesCopy = "D:\\�о���\\20.CCF����\\wordbag\\wordbag.txt";
		WordBag wordBag = new WordBag(pathAllCases, pathAllCasesCopy);
		
		wordBag.List();
	}
}
